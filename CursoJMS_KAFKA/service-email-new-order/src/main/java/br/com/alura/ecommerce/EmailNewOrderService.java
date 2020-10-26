package br.com.alura.ecommerce;

import br.com.alura.ecommerce.consumer.KafkaService;
import br.com.alura.ecommerce.dispatcher.KafkaDispatcher;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Prepara o e-mail para quem quiser enviar um e-mail
 * Incrivel...
 * Ouve as mensagens enviadas por ordem, para enviar um e-mail
 */
public class EmailNewOrderService {

    private final KafkaDispatcher<Email> emailDispatcher = new KafkaDispatcher<>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var emailService = new EmailNewOrderService();
        try (var service = new KafkaService<>(
                EmailNewOrderService.class.getSimpleName()
                , "ECOMMERCE_NEW_ORDER"
                , emailService::parse
                , Map.of())) {
            service.run();
        };
    }

    private void parse(ConsumerRecord<String, Message<Order>> record)
            throws ExecutionException, InterruptedException {
        System.out.println("---------------------------------------------");
        System.out.println("Processing new order, preparing e-mail.");
        System.out.println("KEY: " + record.key() + " / VALUE: " + record.value());
        System.out.println(record.topic() + ":::partition: "
                + record.partition() + " / offset: " + record.offset()
                + " / timestamp: " + record.timestamp());

        var message =  record.value();
        var order = message.getPayload();
        var correlationId = message.getId().continueWith(
                EmailNewOrderService.class.getSimpleName());

        var emailCode = new Email(
                "carlosofpersia@hotmail.com"
                , "Thank you for your order! We are processing your order!");
        emailDispatcher.send("ECOMMERCE_SEND_EMAIL"
                , order.getEmail()
                , correlationId
                , emailCode);
    }
}
