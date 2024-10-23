package com.soa.jmsmgmt;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


/**
 * 
 */
@Component
public class JmsConsumerMt {
  


  @JmsListener(destination = "gerencia.in")
  public void receiveMessage(String message) {
    System.out.println("Mensaje desencolado: " + message);
  }
}
