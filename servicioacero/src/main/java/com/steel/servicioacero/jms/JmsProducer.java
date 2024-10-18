package com.steel.servicioacero.jms;

// Importaciones necesarias para la funcionalidad JMS (Java Message Service)
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

import java.io.IOException;
import java.util.Properties;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;


// La anotación @Service indica que esta clase es un servicio gestionado por Spring, es decir,
// puede ser inyectado como una dependencia en otros componentes.

public class JmsProducer {

    // Declaración de variables que representan los componentes principales de una conexión JMS
    private Context context; // El contexto JNDI que nos permite buscar y utilizar recursos remotos
    private Connection connection; // La conexión activa con el servidor JMS
    private Session session; // La sesión para crear y enviar mensajes
    private Destination destination; // El destino, en este caso, una cola (queue) en JMS
    private MessageProducer messageProducer; // El productor que enviará mensajes a la cola


    // Constructor por defecto de la clase JmsProducer que lanza posibles excepciones
    public JmsProducer() throws NamingException, IOException {

        this.context = createContext("amq.compras.in");
        this.destination = null;
        this.connection = null;
        this.session = null;
        this.messageProducer = null;

    }

    private Context createContext(String queueName) throws NamingException {

        // Configuración de las propiedades para el contexto JNDI, que nos permite buscar y utilizar recursos remotos (como colas)
        Properties env = new Properties();

        // Se especifica la fábrica de contexto inicial de ActiveMQ
        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");

        // URL del proveedor del broker JMS (ActiveMQ en este caso), que es un servidor
        // en la dirección TCP localhost, puerto por defecto 61616, password admin, user admin (por defecto)
        env.put(Context.PROVIDER_URL, "tcp://localhost:61616");

        // Asignamos un nombre lógico para la cola a la que queremos conectarnos
        env.put("queue." + queueName, queueName);

        // Inicializamos y retornamos el contexto JNDI con las propiedades configuradas
        return new InitialContext(env);

    }

    private Connection createConexion() throws NamingException, JMSException {

        // Buscamos la fábrica de conexiones (ConnectionFactory) en el contexto JNDI para conectar con el broker y la retornamos en 'connectionFactory'
        ConnectionFactory connectionFactory = (ConnectionFactory) this.context.lookup("ConnectionFactory");

        // Creamos una conexión utilizando la fábrica obtenida, la iniciamos y la retornamos
        return connectionFactory.createConnection();

    }

    // Método para enviar un mensaje de texto a la cola
    public void sendMessage(String destinationName, String payload, int deliveryMode, int priority, long timeToLive) throws JMSException, NamingException {

        // Creamos una conexión
        this.connection = createConexion();

        // Creamos una sesión JMS sin transacciones y con auto-acknowledge para poder producir un mensaje
        this.session = this.connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // Buscamos la cola de destino en el contexto JNDI
        this.destination = (Destination) this.context.lookup(destinationName);

        // Creamos un productor de mensajes que enviará el mensaje a la cola con la sesión creada anteriormente
        this.messageProducer = session.createProducer(destination);

        // Configuramos los heders deliveryMode, priority y timeToLive del mensaje
        messageProducer.setDeliveryMode(deliveryMode);
        messageProducer.setPriority(priority);
        messageProducer.setTimeToLive(timeToLive);

        // Creamos un mensaje de texto con el contenido proporcionado del payload
        TextMessage message = session.createTextMessage(payload);

        // Asignamos un ID de correlación para el mensaje, útil para rastrear este mensaje específico
        message.setJMSCorrelationID("12345-unique-id");

        // Establecemos el tipo de mensaje, en este caso se indica que es un mensaje detipo JSON
        message.setJMSType("application/json");

        // Enviamos el mensaje a la cola con:
        messageProducer.send(message);

        // Cerramos el productor de mensajes
        messageProducer.close();
        // Cerramos la sesión JMS
        session.close();
        // Cerramos la conexión al broker JMS
        connection.close();

        // Imprimimos en la consola que el mensaje ha sido enviado, para verificar su
        // envío
        System.out.println("Sent message: " + payload);
    }

}
