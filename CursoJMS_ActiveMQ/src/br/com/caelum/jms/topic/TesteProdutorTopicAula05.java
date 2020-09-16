package br.com.caelum.jms.topic;

import java.util.Enumeration;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
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
public class TesteProdutorTopicAula05 {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		/*
		// Usando jndi.properties sem o arquivo, ou seja, diretamente pelo java.
		Properties properties = new Properties();
		properties.setProperty("java.naming.factory.initial", "org.apache.activemq.jndi.ActiveMQInitialContextFactory");

		properties.setProperty("java.naming.provider.url", "tcp://192.168.0.107:61616");
		properties.setProperty("queue.financeiro", "fila.financeiro");
		InitialContext context = new InitialContext(properties);
		*/

		/*(JNDI + JMS, esse InitialContext procura um arquivo chamado jndi.properties)*/
        InitialContext context = new InitialContext();
        

        //imports do package javax.jms
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
        Connection connection = factory.createConnection();


        connection.start();
        /*************************************/

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination topic = (Destination) context.lookup("topicTopicoLoja_JndiProperties");

        /*************************************/

        MessageProducer producer = session.createProducer(topic);
          Message message = session.createTextMessage("<pedido><id>1</id><e-book>false</e-book><nome>Carloss</nome></pedido>");
        message.setBooleanProperty("ebook", false);
        producer.send(message);
        //se nao existe a propriedade tb nao e interessante para a fila, mas se eu colocar la no createDurableSubscriber ebook is null or ebook = true vai trazer os positivos e os que nao tiverem ebook.
        message = session.createTextMessage("<pedido><id>2</id><nome>Eduardoo</nome></pedido>");
        // message.setBooleanProperty("ebook", true);
    	producer.send(message);

        message = session.createTextMessage("<pedido><id>3</id><e-book>true</e-book><nome>Santos!</nome></pedido>");
        message.setBooleanProperty("ebook", true);
        producer.send(message);
    	
        /*
        for (int i = 0; i < 1000; i++) {

        	Message message = session.createTextMessage("<pedido><id>"+i+"</id></pedido>");
        	producer.send(message);
		}
		*/
        
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
        // new Scanner(System.in).nextLine(); 

        session.close();
        connection.close();
        context.close();
	}
}
