package br.com.caelum.jms.logs;

import java.util.Properties;
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
import javax.jms.Topic;
import javax.naming.InitialContext;

/**
 * 
 * MOM (Message Oriented Middleware).
 * 
 * lookup -> significa: pega pra mim!
 * 
 * Pegar sobre JNDI -> Java Naming and Directory Interface 
 * é uma API para acesso a serviços de diretórios. 
 * Ela permite que aplicações cliente descubram e obtenham 
 * dados ou objetos através de um nome.
 *  
 * JNDI + JMS -> http://activemq.apache.org/jndi-support.html
 * example if you place this jndi.properties file on your classpath;
 * 
 * @author carloss
 *
 */
public class TesteConsumidorAula08 {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		// Usando jndi.properties sem o arquivo, ou seja, diretamente pelo java.
		Properties properties = new Properties();
		properties.setProperty("java.naming.factory.initial", "org.apache.activemq.jndi.ActiveMQInitialContextFactory");

		properties.setProperty("java.naming.provider.url", "tcp://192.168.0.107:61616");
		properties.setProperty("queue.queueLOG_JndiProperties", "fila.log");
		InitialContext context = new InitialContext(properties);

        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
       
        Connection connection = factory.createConnection();

        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination fila = (Destination) context.lookup("queueLOG_JndiProperties");
        MessageConsumer consumer = session.createConsumer(fila);

        /*******************************/

        consumer.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message message) {
				System.out.println(message);
				TextMessage textMessage  = (TextMessage) message;
		        try {
					System.out.println(textMessage.getText());
				} catch (JMSException e) {
					e.printStackTrace();
				}

			}
		});
        new Scanner(System.in).nextLine(); 
        session.close();
        connection.close();
        context.close();
	}
}
