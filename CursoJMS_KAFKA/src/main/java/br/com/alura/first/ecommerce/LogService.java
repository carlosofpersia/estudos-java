package br.com.alura.first.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Properties;
import java.util.regex.Pattern;

public class LogService {

    public static void main(String[] args) {

        var consumer = new KafkaConsumer<String, String>(getProperties());
        consumer.subscribe(Pattern.compile("ECOMMERCE.*"));

        while(true) {
            var records = consumer.poll(Duration.ofMillis(100));

            if( !records.isEmpty() ) {
                System.out.println("Encontrei " + records.count() + " registros!");
                int i = 1;
                for(var record: records) {
                    System.out.println("---------------------------------------------");
                    System.out.println("LOG: " + record.topic());
                    System.out.println("KEY: " + record.key() + " / VALUE: " + record.value());
                    System.out.println(record.topic() + ":::partition: " + record.partition() + " / offset: " + record.offset() + " / timestamp: " + record.timestamp());
                    System.out.println("Email Send!");
                    i++;
                }
            }
        }

    }

    private static Properties getProperties() {
        var properties = new Properties();

        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        // obrigatorio receber de um grupo.
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, LogService.class.getSimpleName());

        return properties;
    }


}
