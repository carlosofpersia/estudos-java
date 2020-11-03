package br.com.alura.ecommerce;

import br.com.alura.ecommerce.consumer.KafkaService;

import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * Consumidor
 * Thread SAFE
 */
public class ServiceProvider<T> implements Callable<Void> {

    private final ServiceFactory<T> factory;

    public ServiceProvider(ServiceFactory<T> factory) {
        this.factory = factory;
    }

    public Void call () throws ExecutionException, InterruptedException {

        var myService = factory.create();
        try ( var service = new KafkaService(
                myService.getConsumerGroup()
                , myService.getTopic()
                , myService::parse
                , new HashMap<>())) {
            service.run();
        };
        return null;
    }
}
