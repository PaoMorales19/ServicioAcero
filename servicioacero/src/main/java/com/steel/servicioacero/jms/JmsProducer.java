package com.steel.servicioacero.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * 
 */
@Service
public class JmsProducer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMessage(String message) {
        this.jmsMessagingTemplate.convertAndSend("compras.in", message);
    }
}
