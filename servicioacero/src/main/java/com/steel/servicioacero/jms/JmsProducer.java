package com.steel.servicioacero.jms;

import javax.jms.ConnectionFactory;
import javax.jms.Connection;
import javax.jms.Session;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Message;
import javax.jms.JMSException;
import javax.jms.TextMessage;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.util.Properties;

import org.springframework.stereotype.Service;
//import org.springframework.jms.core.JmsMessagingTemplate;

@Service
public class JmsProducer {

    private ConnectionFactory connectionFactory;
    private Connection connection;
    private Session session;
    private Destination destination;
    private MessageProducer producer;

    public JmsProducer() throws JMSException, NamingException {

        // Set up the JNDI context and connection factory
        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        env.put(Context.PROVIDER_URL, "tcp://localhost:61616");
        env.put("queue.amq.compras.in", "amq.compras.in");
        Context jndiContext = new InitialContext(env);

        // Look up the connection factory
        connectionFactory = (ConnectionFactory) jndiContext.lookup("ConnectionFactory");

        // Create a connection
        connection = connectionFactory.createConnection();
        connection.start();

        // Create a session
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // Create the destination (queue)
        destination = (Destination) jndiContext.lookup("amq.compras.in");

        // Create a producer
        producer = session.createProducer(destination);

    }

    public void sendMessage(String messageText) throws JMSException {

        // Create a text message
        TextMessage message = session.createTextMessage(messageText);

        // Set the message type
        message.setJMSType("application/json");

        // Set the correlation ID
        message.setJMSCorrelationID("12345-unique-id");

        // Send the message
        producer.send(message, javax.jms.DeliveryMode.NON_PERSISTENT, 9, 100000L);
        System.out.println("Sent message: " + messageText);

    }

    public void close() throws JMSException {

        producer.close();
        session.close();
        connection.close();

    }

}
