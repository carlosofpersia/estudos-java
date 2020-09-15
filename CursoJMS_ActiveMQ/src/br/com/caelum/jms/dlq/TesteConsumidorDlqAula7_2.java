package br.com.caelum.jms.dlq;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.naming.InitialContext;

public class TesteConsumidorDlqAula7_2 {

	public static void main(String[] args) throws Exception {

	    // S	ystem.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","java.util, java.lang,br.com.caelum.modelo");
	    // para permitir todos os pacotes 
	    System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","*");
		
        InitialContext context = new InitialContext();
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");

        Connection connection = factory.createConnection();
        
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        /******** Aula 07.2 ***********************/
        
        /*
         * O limite de tentativas de entrega do ACtiveMq e 6 vezes, ou seja, 6 tentativas
         * Quando o objeto a ser consumido se perde, conforme eu tento passar ele, ele vai para uma fila (queue) especial no activemq.
         * ActiveMQ.DLQ - Dead Letter Queue
         * Nessa aula vamos rodas as mensagens que cairam na DLQ - Dead Letter Queue
         * como e uma fila bastar colocala no jndi.properties e definir no lookup
         *  
         */

        Destination fila = (Destination) context.lookup("queueDlq_JndiProperties");
        MessageConsumer consumer = session.createConsumer(fila);

        consumer.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message message) {

				System.out.println(message);
			}
		});

        /******** Aula 07 ***********************/
         
        
        
        new Scanner(System.in).nextLine(); 

        session.close();
        connection.close();
        context.close();
	}
}
