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

import java.util.Properties;

import org.springframework.stereotype.Service;

// La anotación @Service indica que esta clase es un servicio gestionado por Spring, es decir,
// puede ser inyectado como una dependencia en otros componentes.
@Service
public class JmsProducer {

    // Declaración de variables que representan los componentes principales de una
    // conexión JMS
    private Connection connection; // La conexión activa con el servidor JMS
    private Session session; // La sesión para crear y enviar mensajes
    private Destination destination; // El destino, en este caso, una cola (queue) en JMS
    private MessageProducer messageProducer; // El productor que enviará mensajes a la cola

    // Constructor de la clase JmsProducer que lanza posibles excepciones
    // relacionadas con JMS y JNDI
    public JmsProducer() {
        this()
    }

    public JmsProducer(Connection connection, Session session, Destination destination,
            MessageProducer messageProducer) {

        this.connection = connection;
        this.session = session;
        this.destination = destination;
        this.messageProducer = messageProducer;

    }

    private Context createContext() throws NamingException {

        // Configuración del contexto JNDI, que nos permite buscar y utilizar recursos
        // remotos (como colas)
        Properties env = new Properties();
        // Se especifica la fábrica de contexto inicial de ActiveMQ
        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        // URL del proveedor del broker JMS (ActiveMQ en este caso), que es un servidor
        // en la dirección TCP localhost
        env.put(Context.PROVIDER_URL, "tcp://localhost:61616");
        // Asignamos un nombre lógico para la cola a la que queremos conectarnos
        env.put("queue.amq.compras.in", "amq.compras.in");

        // Inicializamos el contexto JNDI con las propiedades configuradas
        return new InitialContext(env);

    }

    private Connection createConexion(Context jndiContext) throws NamingException, JMSException {

        // Buscamos la fábrica de conexiones (ConnectionFactory) en el contexto JNDI
        // para conectar con el broker
        ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("ConnectionFactory");

        // Creamos una conexión utilizando la fábrica obtenida y la iniciamos
        return connectionFactory.createConnection();

    }

    // Método para enviar un mensaje de texto a la cola
    public void sendMessage(String messageText) throws JMSException {

        // Creamos un mensaje de texto con el contenido proporcionado
        TextMessage message = session.createTextMessage(messageText);

        // Establecemos el tipo de mensaje, en este caso se indica que es un mensaje de
        // tipo JSON
        message.setJMSType("application/json");

        // Asignamos un ID de correlación para el mensaje, útil para rastrear este
        // mensaje específico
        message.setJMSCorrelationID("12345-unique-id");

        // Enviamos el mensaje a la cola con:
        // - Modo de entrega no persistente (NON_PERSISTENT), lo que significa que el
        // mensaje no se almacenará en el disco
        // - Prioridad alta (9) para darle mayor prioridad en la cola
        // - Tiempo de vida del mensaje de 100,000 milisegundos (100 segundos) antes de
        // expirar
        producer.send(message, javax.jms.DeliveryMode.NON_PERSISTENT, 9, 100000L);

        // Imprimimos en la consola que el mensaje ha sido enviado, para verificar su
        // envío
        System.out.println("Sent message: " + messageText);
    }

    // Método para cerrar todos los recursos relacionados con JMS cuando ya no sean
    // necesarios
    public void close() throws JMSException {

        // Cerramos el productor de mensajes
        producer.close();
        // Cerramos la sesión JMS
        session.close();
        // Cerramos la conexión al broker JMS
        connection.close();
    }
}
