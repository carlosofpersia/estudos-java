package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.HashMap;

public class EmailService {

    public static void main(String[] args) {

        var emailService = new EmailService();
        try ( var service = new KafkaService<Email>(EmailService.class.getSimpleName()
                , "ECOMMERCE_SEND_EMAIL", emailService::parse, Email.class
                , new HashMap<>())) {
            service.run();
        };
    }

    private void parse(ConsumerRecord<String, Email> record) {

        System.out.println("---------------------------------------------");
        System.out.println("Send email");
        System.out.println("KEY: " + record.key() + " / VALUE: " + record.value());
        System.out.println(record.topic() + ":::partition: " + record.partition() + " / offset: " + record.offset() + " / timestamp: " + record.timestamp());
        System.out.println("Email Send!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // ignoring
            e.printStackTrace();
        }


    }


}