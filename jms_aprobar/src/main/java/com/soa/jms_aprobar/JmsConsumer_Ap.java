package com.soa.jms_aprobar;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsConsumer_Ap {
    @JmsListener(destination = "compras.in")
  public void receiveMessage(String message) {
    System.out.println("Mensaje desencolado: " + message);
  }

}
