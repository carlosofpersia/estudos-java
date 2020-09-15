package br.com.caelum.jms_jaxb;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.Topic;
import javax.naming.InitialContext;

import br.com.caelum.modelo.Pedido;

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
public class TesteConsumidorTopicComercialAula7_1 {

	public static void main(String[] args) throws Exception {

	    // System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","java.util, java.lang,br.com.caelum.modelo");
	    // para permitir todos os pacotes 
	    System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","*");

		
        InitialContext context = new InitialContext();
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
       
        Connection connection = factory.createConnection();
        connection.setClientID("comercial");
        
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topico = (Topic) context.lookup("topicTopicoLoja_JndiProperties");
        MessageConsumer consumer = session.createDurableSubscriber(topico, "assinatura");
        
        /******** Aula 07 ***********************/

        consumer.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message message) {

				
				ObjectMessage objectMessage  = (ObjectMessage) message;
		        try {

		        	//Pedido deve ser um objeto serializavel.
		        	Pedido pedido = (Pedido) objectMessage.getObject();
					System.out.println(pedido.getCodigo());

				} catch (JMSException e) {
					e.printStackTrace();
				}

			}
		});
        new Scanner(System.in).nextLine(); 
        
        /*
         * O limite de tentativas de entrega do ACtiveMq e 6 vezes, ou seja, 6 tentativas
         * Quando o objeto a ser consumido se perde, conforme eu tento passar ele, ele vai para uma fila (queue) especial no activemq.
         * ActiveMQ.DLQ - Dead Letter Queue 
         */
         
        
        
        /******** Aula 07 ***********************/

        session.close();
        connection.close();
        context.close();
	}
}
