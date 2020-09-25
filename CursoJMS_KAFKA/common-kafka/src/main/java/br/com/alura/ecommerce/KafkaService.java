package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.io.Closeable;
import java.time.Duration;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.regex.Pattern;

public class KafkaService<T> implements Closeable {

    private final KafkaConsumer<String, T> consumer;
    private final ConsumerFunction parse;

    public KafkaService(String groupId, String topic
            , ConsumerFunction parse, Class<T> type
            , Map<String, String> properties) {
        this(parse, groupId, type, properties);
        this.consumer.subscribe(Collections.singletonList(topic));
    }

    public KafkaService(String groupId, Pattern topic
            , ConsumerFunction parse, Class<T> type
            , Map<String, String> properties) {
        this(parse, groupId, type, properties);
        this.consumer.subscribe(topic);
    }

    private KafkaService(ConsumerFunction parse, String groupId
         , Class<T> type, Map<String, String> properties) {
        this.parse = parse;
        this.consumer = new KafkaConsumer<>(getProperties(type, groupId, properties));
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
                System.out.println("Aguardando registros!");
            }
        }
    }

    private Properties getProperties(Class<T> type, String groupId, Map<String, String> overrideProperties) {
        var properties = new Properties();

        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, GsonDeserializer.class.getName());

        // obrigatorio receber de um grupo.
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);

        //CLIENT_ID_CONFIG aqui colocar o ip da maquina ou o id do usuario
        properties.setProperty(ConsumerConfig.CLIENT_ID_CONFIG, UUID.randomUUID().toString());

        //MAX_POLL_RECORDS_CONFIG max de registros para commitar. menos chance de perder registros.
        properties.setProperty(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "1");

        //Resolve o problema de deserializar um tipo de objeto em configure da GsonDeserializer
        properties.setProperty(GsonDeserializer.TYPE_CONFIG, type.getName());

        //Problema com deserializacao de String para Gson na hora de deserializar.
        properties.putAll(overrideProperties);

        return properties;
    }


    @Override
    public void close() {
        consumer.close();
    }
}



