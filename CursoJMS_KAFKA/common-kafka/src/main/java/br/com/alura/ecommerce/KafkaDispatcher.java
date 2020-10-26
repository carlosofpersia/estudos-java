package br.com.alura.ecommerce;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.Closeable;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Classe Producer - chamou-se KafkaDispatcher pq ja existe uma KafkaProducer.
 */
class KafkaDispatcher<T> implements Closeable {

    private final KafkaProducer<String, Message<T>> producer;

    KafkaDispatcher() {
        this.producer = new KafkaProducer<>(properties());
    }

    /**
     * sendAndWait
     * Envia e espera
     * send + get
     */
    public void send(String topic, String key, CorrelationId id, T payload) throws ExecutionException, InterruptedException {

        Future<RecordMetadata> future = sendAsync(topic, key, id, payload);
        future.get();
    }

    /**
     * Envia assincrona
     */
    Future<RecordMetadata> sendAsync(String topic, String key, CorrelationId id, T payload) throws ExecutionException, InterruptedException {

        var value = new Message<>(id, payload);
        var record = new ProducerRecord<>(topic, key, value);
        Callback callback = (data, ex) -> {
            if (ex != null) {
                ex.printStackTrace();
                return;
            }
            System.out.println("Producer::" + topic);
            System.out.println("Sucesso enviando " + data.topic() + ":::partition: " + data.partition() + " / offset: " + data.offset() + " / timestamp: " + data.timestamp());
        };
        return producer.send(record, callback);
    }

    private static Properties properties() {
        var properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, GsonSerializer.class.getName());

        // somente da ok, quando todas as replicas confirmarem, isso e bom para garantir que se um cair esta no outro.
        properties.setProperty(ProducerConfig.ACKS_CONFIG, "all");

        return properties;
    }

    @Override
    public void close() {
        producer.close();
    }
}
