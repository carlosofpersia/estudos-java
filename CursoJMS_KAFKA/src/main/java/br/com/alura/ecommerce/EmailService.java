package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class EmailService {

    public static void main(String[] args) {

        var consumer = new KafkaConsumer<String, String>(getProperties());
        consumer.subscribe(Collections.singletonList("ECOMMERCE_SEND_EMAIL"));

        while(true) {
            var records = consumer.poll(Duration.ofMillis(100));

            if( !records.isEmpty() ) {
                System.out.println("Encontrei " + records.count() + " registros!");
                int i = 1;
                for(var record: records) {
                    System.out.println("---------------------------------------------");
                    System.out.println("Send email" + i);
                    System.out.println("KEY: " + record.key() + " / VALUE: " + record.value());
                    System.out.println(record.topic() + ":::partition: " + record.partition() + " / offset: " + record.offset() + " / timestamp: " + record.timestamp());
                    System.out.println("Email Send!");
                    i++;
                }
            } else {
                System.out.println("Email.Aguardando registros!");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // ignoring
                e.printStackTrace();
            }
        }

    }

    private static Properties getProperties() {
        var properties = new Properties();

        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        // obrigatorio receber de um grupo.
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, EmailService.class.getSimpleName());

        return properties;
    }


}
