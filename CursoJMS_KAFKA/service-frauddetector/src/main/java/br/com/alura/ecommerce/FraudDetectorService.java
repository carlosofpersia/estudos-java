package br.com.alura.ecommerce;

import br.com.alura.ecommerce.consumer.ConsumerService;
import br.com.alura.ecommerce.consumer.ServiceRunner;
import br.com.alura.ecommerce.database.LocalDatabase;
import br.com.alura.ecommerce.dispatcher.KafkaDispatcher;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

public class FraudDetectorService implements ConsumerService<Order> {

    private final KafkaDispatcher<Order> orderDispatcher = new KafkaDispatcher<>();

    private final LocalDatabase database;

    FraudDetectorService() throws SQLException {
        this.database = new LocalDatabase("frauds_database");
        this.database.createIfNotExists("create table Orders (uuid varchar (200) primary key, is_fraud boolean)");
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, SQLException {

        // como o banco de dados e local que e um arquivo uso 1, mas se fosse remoto eu poderia usar 5, 10 ...
        new ServiceRunner(FraudDetectorService::new).start(1);
/*
        var fraudDetectorService = new FraudDetectorService();
        try (var service = new KafkaService<Order>(
                FraudDetectorService.class.getSimpleName()
                , "ECOMMERCE_NEW_ORDER"
                , fraudDetectorService::parse
                , new HashMap<>())) {
            service.run();
        };
 */
    }

    @Override
    public String getConsumerGroup() {
        return FraudDetectorService.class.getSimpleName();
    }

    @Override
    public String getTopic() {
        return "ECOMMERCE_NEW_ORDER";
    }

    @Override
    public void parse(ConsumerRecord<String, Message<Order>> record) throws ExecutionException, InterruptedException, SQLException {
        System.out.println("---------------------------------------------");
        System.out.println("Processing new order, checking for fraud");
        System.out.println("KEY: " + record.key() + " / VALUE: " + record.value());
        System.out.println(record.topic() + ":::partition: " + record.partition() + " / offset: " + record.offset() + " / timestamp: " + record.timestamp());

        var message = record.value();
        var order = message.getPayload();
        if( wasProcessed(order) ) {
            System.out.println("Order "+ order.getOrderId() +" was already processed!");
            return;
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // ignoring
            e.printStackTrace();
        }

        if(isFraud(order)) {

            database.update("insert into Orders (uuid, is_fraud) values (?, true)"
                    , order.getOrderId());

            // pretending that the fraud happens when the amount is >= 4500 ;
            System.out.println("Order is a fraud!!!" + order.getOrderId() + " Reproved!");
            orderDispatcher.send("ECOMMERCE_ORDER_REJECTED"
                    , order.getEmail()
                    , message.getId().continueWith(FraudDetectorService.class.getSimpleName())
                    , order);
        } else {

            database.update("insert into Orders (uuid, is_fraud) values (?, false)"
                    , order.getOrderId());

            System.out.println("Order not is a fraud. Order: " + order.getOrderId() + " Approved!");
            orderDispatcher.send("ECOMMERCE_ORDER_APPROVED"
                    , order.getEmail()
                    , message.getId().continueWith(FraudDetectorService.class.getSimpleName())
                    , order);
        }
    }

    private boolean wasProcessed(Order order) throws SQLException {
        var results = database.query (
                "select uuid from Orders where uuid = ? limit 1"
                , order.getOrderId());
        return results.next();
    }

    private boolean isFraud(Order order) {
        return order.getAmount().compareTo(new BigDecimal("4500")) >= 0;
    }

}
