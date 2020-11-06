package br.com.alura.ecommerce;

import br.com.alura.ecommerce.consumer.ConsumerService;
import br.com.alura.ecommerce.consumer.ServiceRunner;
import br.com.alura.ecommerce.database.LocalDatabase;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class CreateUserService implements ConsumerService<Order> {

    private final LocalDatabase database;

    CreateUserService() throws SQLException {
        this.database = new LocalDatabase("users_database");
        this.database.createIfNotExists("create table Users (uuid varchar (200) primary key, email varchar(200))");
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, SQLException {

        // uma unica instancia por vez, pois estou usando arquivo em disco.
        new ServiceRunner(CreateUserService::new).start(1);

        /*
        var createUserService = new CreateUserService();
        try (var service = new KafkaService<Order>(
                CreateUserService.class.getSimpleName()
                , "ECOMMERCE_NEW_ORDER"
                , createUserService::parse
                , new HashMap<>())) {
            service.run();
        };
         */
    }

    @Override
    public String getConsumerGroup() {
        return CreateUserService.class.getSimpleName();
    }

    @Override
    public String getTopic() {
        return "ECOMMERCE_NEW_ORDER";
    }

    @Override
    public void parse(ConsumerRecord<String, Message<Order>> record) throws SQLException {

        var message = record.value();
        System.out.println("---------------------------------------------");
        System.out.println("Processing new order, checking for new USER");
        System.out.println("KEY: " + record.key() + " / VALUE: " + record.value());
        System.out.println(record.topic() + ":::partition: " + record.partition() + " / offset: " + record.offset() + " / timestamp: " + record.timestamp());
        System.out.println("Order processed!");

        var order = message.getPayload();
        if(!isNewUser(order.getEmail())) {
            insertNewUser(order.getEmail());
        } else {
            System.out.println("****** Email existe!");
        }
    }

    private void insertNewUser(String email) throws SQLException {

        var statement = "insert into Users (uuid, email) values (?, ? )";
        String uuid = UUID.randomUUID().toString();
        this.database.update(statement, uuid, email);
        System.out.println("****** Usuario criado com sucesso, [" + uuid + "] " + email);
    }

    private boolean isNewUser(String email) throws SQLException {
        var results = database.query ("select uuid from Users where email = ? limit 1", email);
        return results.next();
    }

}
