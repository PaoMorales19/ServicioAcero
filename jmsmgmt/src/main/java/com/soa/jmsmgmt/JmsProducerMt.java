package com.soa.jmsmgmt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;


/**
 * 
 */
@Service
public class JmsProducerMt {


  @Autowired
  private JmsMessagingTemplate jmsMessagingTemplate;


  public void sendMessage(String message) {
    this.jmsMessagingTemplate.convertAndSend("compras.out", message);
  }
}
