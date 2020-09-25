package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.HashMap;

public class FraudDetectorService {

    public static void main(String[] args) {
        var fraudDetectorService = new FraudDetectorService();
        try (var service = new KafkaService<Order>(FraudDetectorService.class.getSimpleName()
                , "ECOMMERCE_NEW_ORDER", fraudDetectorService::parse, Order.class
                , new HashMap<>())) {
            service.run();
        };
    }

    private void parse(ConsumerRecord<String, Order> record) {
        System.out.println("---------------------------------------------");
        System.out.println("Processing new order, checking for fraud");
        System.out.println("KEY: " + record.key() + " / VALUE: " + record.value());
        System.out.println(record.topic() + ":::partition: " + record.partition() + " / offset: " + record.offset() + " / timestamp: " + record.timestamp());
        System.out.println("Order processed!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // ignoring
            e.printStackTrace();
        }
    }

}
