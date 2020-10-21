package br.com.alura.ecommerce;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {

    public static void main(String [] args) throws ExecutionException, InterruptedException {

        try (var orderDispatcher = new KafkaDispatcher<Order>();
             var emailDispatcher = new KafkaDispatcher<Email>()) {

            var email = "cadu_" + Math.random() + "@email.com";
            for (var i = 0; i < 10 ; i++)
            {
                var orderId = UUID.randomUUID().toString();
                var amount = new BigDecimal(Math.random() * 5000 + 1);

                var order = new Order(orderId, amount, email);
                orderDispatcher.send("ECOMMERCE_NEW_ORDER"
                        , email
                        , new CorrelationId(NewOrderMain.class.getSimpleName())
                        , order);

                var emailCode = new Email("carlosofpersia@hotmail.com", "Thank you for your order! We are processing your order!");
                emailDispatcher.send("ECOMMERCE_SEND_EMAIL"
                        , email
                        , new CorrelationId(NewOrderMain.class.getSimpleName())
                        , emailCode);
            }
        }
    }
}
