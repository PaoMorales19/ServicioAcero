package com.steel.servicioacero.jms;


import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import java.util.Map;

@Service
public class JmsProducer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMessage(String body) {
        // Crear mapa para los headers
        Map<String, Object> messageHeaders = new HashMap<>();
        messageHeaders.put("JMSCorrelationID", "12345"); // Agregar header
        messageHeaders.put("JMSPriority", 5); // Cambiar prioridad
        messageHeaders.put("JMSType", "text"); // Cambiar tipo de mensaje

        // Enviar mensaje con headers personalizados
        this.jmsMessagingTemplate.convertAndSend("amq.compras.in", body, messageHeaders);
    }
}

