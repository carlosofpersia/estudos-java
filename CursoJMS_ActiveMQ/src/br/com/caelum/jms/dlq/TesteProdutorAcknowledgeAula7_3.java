package br.com.caelum.jms.dlq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.InitialContext;

public class TesteProdutorAcknowledgeAula7_3 {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

        InitialContext context = new InitialContext();

        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
        Connection connection = factory.createConnection();

        connection.start();
        /*************************************/

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination fila = (Destination) context.lookup("queueFilaFinanceiro_JndiProperties");

        /*************************************/
        
        MessageProducer producer = session.createProducer(fila);

        int i = 16;
    	Message message = session.createTextMessage("<pedido><id>"+i+"</id></pedido>");
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
