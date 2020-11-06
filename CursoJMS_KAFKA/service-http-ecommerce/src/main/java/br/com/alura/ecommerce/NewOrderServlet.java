package br.com.alura.ecommerce;

import br.com.alura.ecommerce.dispatcher.KafkaDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

public class NewOrderServlet extends HttpServlet {

    //nao chamo o banco de dados igual no consumer, pq um HTTP nao e thread safe. chamo toda vez quer for usar.

    private final KafkaDispatcher<Order> orderDispatcher = new KafkaDispatcher<>();

    @Override
    public void destroy() {
        orderDispatcher.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

                try {

                    // we are not caring about any security issues, we are only
                    // showing how to use http as a starting point.

                    // var email = "cadu_" + Math.random() + "@email.com";
                    // var amount = new BigDecimal(Math.random() * 5000 + 1);
                    // var orderId = UUID.randomUUID().toString();

                    var email = req.getParameter("email");
                    var amount = new BigDecimal(req.getParameter("amount"));
                    var orderId = req.getParameter("uuid");
                    var order = new Order(orderId, amount, email);

                    try (var database = new OrdersDatabase()) {
                        if (!database.saveNew(order)) {

                            orderDispatcher.send("ECOMMERCE_NEW_ORDER"
                                    , email
                                    , new CorrelationId(NewOrderServlet.class.getSimpleName())
                                    , order);

                        /* Nao preciso mais, agora eu tenho um servico que prepara
                         * o e-mail quando ouve um ECOMMERCE_NEW_ORDER.
                        var emailCode = new Email("carlosofpersia@hotmail.com"
                        * , "Thank you for your order! We are processing your order!");
                        * private final KafkaDispatcher<Email> emailDispatcher = new KafkaDispatcher<>();
                        emailDispatcher.send("ECOMMERCE_SEND_EMAIL"
                                , email
                                , new CorrelationId(NewOrderServlet.class.getSimpleName())
                                , emailCode);
                                * emailDispatcher.close();
                         */

                            var msgResult = "New order sent sucessfully.";
                            System.out.println(msgResult);
                            resp.setStatus(HttpServletResponse.SC_OK);
                            resp.getWriter().println(msgResult);
                        } else {
                            var msgResult = "Old order received.";
                            System.out.println(msgResult);
                            resp.setStatus(HttpServletResponse.SC_OK);
                            resp.getWriter().println(msgResult);
                        }
                    }


                } catch (ExecutionException| InterruptedException | SQLException e) {
                    throw new ServletException(e);
                }


    }
}
