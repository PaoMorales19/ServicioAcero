package com.steel.servicioacero.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.core.MessagePostProcessor;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

/**
 * 
 */
@Service
public class JmsProducer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMessage(String body) {
        this.jmsMessagingTemplate.convertAndSend("amq.compras.in", body, new MessagePostProcessor() {

            @Override
            public Message<?> postProcessMessage(Message<?> message) {

                return message;
            }

        });

    }
}
