package br.com.caelum.jms.logs;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.InitialContext;

import org.omg.CORBA.PERSIST_STORE;

/**
 * Aula 08 - LOGS
 * Usar JNDI - PROPERTIES na mao.
 * 
 * @author carloss
 *
 */
public class TesteProdutorAula08 {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		// Usando jndi.properties sem o arquivo, ou seja, diretamente pelo java.
		Properties properties = new Properties();
		properties.setProperty("java.naming.factory.initial", "org.apache.activemq.jndi.ActiveMQInitialContextFactory");

		properties.setProperty("java.naming.provider.url", "tcp://192.168.0.107:61616");
		properties.setProperty("queue.queueLOG_JndiProperties", "fila.log");
		InitialContext context = new InitialContext(properties);

        //imports do package javax.jms
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
        Connection connection = factory.createConnection();

        connection.start();
        /*************************************/

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination fila = (Destination) context.lookup("queueLOG_JndiProperties");

        /*************************************/

        MessageProducer producer = session.createProducer(fila);
    	/* 
    	 * Aula08 Apice:
    	 * 
    	 *
    	 * Se o active MQ cai, nao precisa recuperar as mensagens de LOG
    	 * DeliveryMode.NON_PERSISTENT
    	 * 
    	 * Se o active MQ cai, ele salva em um banco de dados do activemq e consegue recuperar depois.
    	 * DeliveryMode.PERSISTENT
    	 * 
    	 * 
    	 * Prioridade tem que configurar o arquivo ./apache-activemq-5.15.13/conf/activemq.xml 
    	 * linha 45: "<policyEntry queue=">" prioritizedMessages="true"/>"
    	 * valores de 0 a 9
    	 * priority
    	 * 
    	 * Tempo em microsegundos para a mensagem sobreviver em milisegundos (5000 = 5s).
    	 * timeToLive
    	 * 
    	 */
        Message message = session.createTextMessage("WARN - Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos. Lorem Ipsum sobreviveu não só a cinco séculos, como também ao salto para a editoração eletrônica, permanecendo essencialmente inalterado. Se popularizou na década de 60, quando a Letraset lançou decalques contendo passagens de Lorem Ipsum, e mais recentemente quando passou a ser integrado a softwares de editoração eletrônica como Aldus PageMaker.\n");
    	producer.send(message, DeliveryMode.NON_PERSISTENT, 7, 80000);


        /*************************************/
        // new Scanner(System.in).nextLine(); 

        session.close();
        connection.close();
        context.close();
	}
}
