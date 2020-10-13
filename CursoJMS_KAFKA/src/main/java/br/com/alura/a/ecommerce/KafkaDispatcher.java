package br.com.alura.a.ecommerce;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.Closeable;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * Classe Producer - chamou-se KafkaDispatcher pq ja existe uma KafkaProducer.
 */
class KafkaDispatcher implements Closeable {

    private final KafkaProducer<String, String> producer;

    KafkaDispatcher() {
        this.producer = new KafkaProducer<>(properties());
    }

    public void send(String topic, String key, String value) throws ExecutionException, InterruptedException {

        var record = new ProducerRecord<>(topic, key, value);
        Callback callback = (data, ex) -> {
            if (ex != null) {
                ex.printStackTrace();
                return;
            }
            System.out.println("Producer::" + topic);
            System.out.println("Sucesso enviando " + data.topic() + ":::partition: " + data.partition() + " / offset: " + data.offset() + " / timestamp: " + data.timestamp());
        };
        producer.send(record, callback).get();
    }

    private static Properties properties() {
        var properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return properties;
    }

    @Override
    public void close() {
        producer.close();
    }
}