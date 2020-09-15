package br.com.caelum.jms.topic;

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
public class TesteConsumidorTopicEstoqueSelectorAula06 {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

        InitialContext context = new InitialContext();
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
       
        Connection connection = factory.createConnection();
        connection.setClientID("estoque");

        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topico = (Topic) context.lookup("topicTopicoLoja_JndiProperties");
        
        /**************************************/
        // Aula 06

        // ultimo parametro serve para dizer se a conexao tb pode ser um produtor e um consumidor, falso nao pode.
        // MessageConsumer consumer = session.createDurableSubscriber(topico, "assinatura", "JMSType = 'car' AND color = 'blue' AND weight > 2500", false);
        MessageConsumer consumer = session.createDurableSubscriber(topico, "assinatura-selector", "ebook is null OR ebook=true", false);
        /**************************************/

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
