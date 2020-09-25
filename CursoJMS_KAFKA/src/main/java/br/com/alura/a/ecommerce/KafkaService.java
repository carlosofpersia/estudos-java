package br.com.alura.a.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.io.Closeable;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.UUID;

public class KafkaService implements Closeable {

    private final KafkaConsumer<String, String> consumer;
    private final ConsumerFunction parse;

    public KafkaService(String groupId, String topic, ConsumerFunction parse) {

        this.parse = parse;
        this.consumer = new KafkaConsumer<>(getProperties(groupId));
        this.consumer.subscribe(Collections.singletonList(topic));
    }

    public void run() {

        while(true) {
            var records = consumer.poll(Duration.ofMillis(100));
            if( !records.isEmpty() ) {
                System.out.println("Encontrei " + records.count() + " registros!");
                for(var record: records) {
                    parse.consumer(record);
                }
            } else {
                System.out.println("Email.Aguardando registros!");
            }
        }
    }

    private static Properties getProperties(String groupId) {
        var properties = new Properties();

        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        // obrigatorio receber de um grupo.
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);

        //CLIENT_ID_CONFIG aqui colocar o ip da maquina ou o id do usuario
        properties.setProperty(ConsumerConfig.CLIENT_ID_CONFIG, UUID.randomUUID().toString());

        //MAX_POLL_RECORDS_CONFIG max de registros para commitar. menos chance de perder registros.
        properties.setProperty(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "1");

        return properties;
    }


    @Override
    public void close() {
        consumer.close();
    }
}



