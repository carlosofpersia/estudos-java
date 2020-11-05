package br.com.alura.ecommerce.dispatcher;

import br.com.alura.ecommerce.CorrelationId;
import br.com.alura.ecommerce.Message;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.config.TopicConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.Closeable;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * KafkaDispatcher + GsonSerializer
 * Classe Producer - chamou-se KafkaDispatcher pq ja existe uma KafkaProducer.
 */
public class KafkaDispatcher<T> implements Closeable {

    private final KafkaProducer<String, Message<T>> producer;

    public KafkaDispatcher() {
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
    public Future<RecordMetadata> sendAsync(String topic, String key, CorrelationId id, T payload) throws ExecutionException, InterruptedException {

        var value = new Message<>(id.continueWith("_"+topic), payload);
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

/*
 * produzir um unico registro e commitar manual  - Aula 04
 * https://itnext.io/kafka-transaction-56f022af1b0c
properties.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG, transactionalId); // producer unique transactional id.
properties.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, true);
properties.put(ProducerConfig.ACKS_CONFIG, "all");
properties.put(ProducerConfig.RETRIES_CONFIG, 3);
properties.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, 1);
properties.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, 600000);
*/

        //Qtd minima de replicas de servidores kafkas ativos
        // properties.setProperty(TopicConfig.MIN_IN_SYNC_REPLICAS_CONFIG, 2);

        // somente da ok, quando todas as replicas confirmarem, isso e bom para garantir que se um cair esta no outro.
        properties.setProperty(ProducerConfig.ACKS_CONFIG, "all");

        return properties;
    }

    @Override
    public void close() {
        producer.close();
    }
}
