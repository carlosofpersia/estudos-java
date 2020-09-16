package br.com.caelum.jms.queue;

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
public class TesteConsumidorAula03 {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		/*(JNDI + JMS, esse InitialContext procura um arquivo chamado jndi.properties)*/
        InitialContext context = new InitialContext();

        //imports do package javax.jms
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
        Connection connection = factory.createConnection();

        connection.start();

        /*************************************/
        
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination fila = (Destination) context.lookup("queueFilaFinanceiro_JndiProperties");
        MessageConsumer consumer = session.createConsumer(fila);

        /*
        Message message = consumer.receive(2000);
        System.out.println("Recebendo msg CADU: "+ message);
        ou
        */

        //delega a mensagem para o tratador de mensagem
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
        
        
        
        /*
         // somente visualizar/monitorar as mensagens da fila
        QueueBrowser browser = session.createBrowser((Queue) fila);

        Enumeration<?> msgs = browser.getEnumeration();
        while (msgs.hasMoreElements()) { 
            TextMessage msg = (TextMessage) msgs.nextElement(); 
            System.out.println("Message: " + msg.getText()); 
        }
        
        */
        
        
        /*************************************/

        new Scanner(System.in).nextLine(); 

        session.close();
        connection.close();
        context.close();
	}
}
