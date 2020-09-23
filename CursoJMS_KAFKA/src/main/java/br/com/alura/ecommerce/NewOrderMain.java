package br.com.alura.ecommerce;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {

    public static void main(String [] args) throws ExecutionException, InterruptedException {

        var producer = new KafkaProducer<String, String>(properties());

        Callback callback = (data, ex) -> {
            if (ex != null) {
                ex.printStackTrace();
                return;
            }
            System.out.println("Producer item new order");
            System.out.println("Sucesso enviando " + data.topic() + ":::partition: " + data.partition() + " / offset: " + data.offset() + " / timestamp: " + data.timestamp());
        };

        for (var i = 0; i < 100 ; i++)
        {
            var key = UUID.randomUUID().toString();
            var value = key + ",456,789.00";
            var record = new ProducerRecord<>("ECOMMERCE_NEW_ORDER", key, value);
            producer.send(record, callback).get();
        }
        var keyEmail = UUID.randomUUID().toString();
        var email = " Thank you for your order! We are processing your order!";
        var emailRecord = new ProducerRecord<>("ECOMMERCE_SEND_EMAIL", keyEmail, email);
        producer.send(emailRecord, callback).get();
        System.out.println("OK!");
    }

    private static Properties properties() {
        var properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return properties;
    }
}
