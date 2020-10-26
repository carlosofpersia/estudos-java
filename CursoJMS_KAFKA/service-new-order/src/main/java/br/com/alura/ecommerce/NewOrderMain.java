package br.com.alura.ecommerce;

import br.com.alura.ecommerce.dispatcher.KafkaDispatcher;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

/**
 * Fast delegate, retirei o e-mail daqui, agora ele e preparado em um servico especifico.
 */
public class NewOrderMain {

    public static void main(String [] args) throws ExecutionException, InterruptedException {

        try (var orderDispatcher = new KafkaDispatcher<Order>();) {

            var email = "cadu_" + Math.random() + "@email.com";
            for (var i = 0; i < 10 ; i++)
            {
                var orderId = UUID.randomUUID().toString();
                var amount = new BigDecimal(Math.random() * 5000 + 1);

                var id = new CorrelationId(NewOrderMain.class.getSimpleName());

                var order = new Order(orderId, amount, email);
                orderDispatcher.send("ECOMMERCE_NEW_ORDER"
                        , email
                        , id
                        , order);

                /*
                 * Nao preciso mais, agora eu tenho um servico service-emaill-new-order
                 * que prepara o e-mail quando ouve um ECOMMERCE_NEW_ORDER.
                var emailDispatcher = new KafkaDispatcher<Email>()
                var emailCode = new Email("carlosofpersia@hotmail.com", "Thank you for your order! We are processing your order!");
                emailDispatcher.send("ECOMMERCE_SEND_EMAIL"
                        , email
                        , id
                        , emailCode);
                        */

            }
        }
    }
}
