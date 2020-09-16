package br.com.caelum.jms.dlq;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

public class TesteConsumidorAcknowledgeAula7_3 {

	public static void main(String[] args) throws Exception {

	    System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","*");
		
        InitialContext context = new InitialContext();
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");

        Connection connection = factory.createConnection();
        
        connection.start();

        /******** Aula 07.3 ***********************/

        /**
         * Session.AUTO_ACKNOWLEDGE
         * Session.CLIENT_ACKNOWLEDGE
         * Session.DUPS_OK_ACKNOWLEDGE
         * Session.SESSION_TRANSACTED
         */

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        // Session session = connection.createSession(true, Session.SESSION_TRANSACTED);
        // Session session = connection.createSession(true, Session.DUPS_OK_ACKNOWLEDGE);

        Destination fila = (Destination) context.lookup("queueFilaFinanceiro_JndiProperties");
        MessageConsumer consumer = session.createConsumer(fila);

        consumer.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message message) {
				TextMessage textMessage  = (TextMessage) message;
		        try {
		        	/*
		        	 * Session.AUTO_ACKNOWLEDGE confirma recebimento da fila automatico
		        	 * 
		        	 * ----------------------------------------
		        	 * 
		        	 * Session.CLIENT_ACKNOWLEDGE tenho que avisar manualmente aqui dentro do try.
		        	 * TextMessage textMessage  = (TextMessage) message;
		        	 * textMessage.acknowledge();
		        	 * 
		        	 * ----------------------------------------
		        	 * 
		        	 * Session.SESSION_TRANSACTED - transacao parecida com transacoes do banco de dados
		        	 * session.commit();
		        	 * session.rollback(); -> legal que envia para a fila dlq.
		        	 * 
		        	 * ----------------------------------------
		        	 * 
		        	 * Session.DUPS_OK_ACKNOWLEDGE - aceita mensagens duplicadas
		        	 * 
		        	 */ 

					System.out.println(textMessage.getText());
				} catch (JMSException e) {
					// session.rollback();
					e.printStackTrace();
				}
			}
		});
        /******** Aula 07.3 ***********************/

        new Scanner(System.in).nextLine(); 

        session.close();
        connection.close();
        context.close();
	}
}
