package com.steel.servicioacero.jms;

//import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.JMSException;
import javax.jms.Message;

@Service
public class JmsProducer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMessage(String payload) {
        this.jmsMessagingTemplate.convertAndSend("compras.out", payload){


    }
}

}

    
