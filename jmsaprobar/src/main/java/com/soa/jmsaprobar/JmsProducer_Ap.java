package com.soa.jmsaprobar;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;

@Service
public class JmsProducer_Ap {

  @Autowired
  private JmsMessagingTemplate jmsMessagingTemplate;

  public void sendMessage(String destination, String message) {

    this.jmsMessagingTemplate.convertAndSend(destination, message);

  }

}
