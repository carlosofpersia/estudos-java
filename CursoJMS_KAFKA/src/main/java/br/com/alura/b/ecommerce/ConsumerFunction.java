package br.com.alura.b.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface ConsumerFunction<T> {

    void consumer(ConsumerRecord<String, T> record);
}
