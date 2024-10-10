package com.soa.jms_aprobar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

@Service

public class JmsProducer_Ap {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
  
  
    public void sendMessage(String message) {
      this.jmsMessagingTemplate.convertAndSend("compras.out", message);
    }
    
}
