package br.com.caelum.jms.dlq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.InitialContext;

import br.com.caelum.modelo.Pedido;
import br.com.caelum.modelo.PedidoFactory;

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
 * JMS + JAX_B para criar os dados do XML
 * 
 * @author carloss
 *
 */
public class TesteProdutorDlqAula07_2 {

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
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination topic = (Destination) context.lookup("topicTopicoLoja_JndiProperties");
        MessageProducer producer = session.createProducer(topic);

        /************** Aula 07 ********************************************/

        /* 2 Formas essa commitada e por XML.
         * Aula 07 - Tratanto o XML para objeto JAVA
         * magica da aula e o JAXB MARSHAL para gerar o XML bind
         * nao vou mandar um objeto xml, pois o java estar enviando um java. ele se resolve.
        Pedido pedido = new PedidoFactory().geraPedidoComValores();
        StringWriter writer = new StringWriter();
        JAXB.marshal(pedido, writer);
        String xml = writer.toString();
        // Message message = session.createTextMessage("<pedido><id>1</id><e-book>false</e-book><nome>Carloss</nome></pedido>");
        Message message = session.createTextMessage(xml);
        System.out.println(xml);
         */
        
        /*
         * Aula 07 - Tratanto o objeto direto para enviar.
         * Deve ser serializavel
         */
        Pedido pedido = new PedidoFactory().geraPedidoComValores();
        Message message = session.createObjectMessage(pedido);

        message.setBooleanProperty("ebook", true);
        producer.send(message);

        /************** Aula 07 ********************************************/  

    	
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
