package com.soa.jmsaprobar;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.steel.servicioacero.dto.PurchaseRequest;

@Component
public class JmsConsumer_Ap {

  @JmsListener(destination = "compras.in")
  public void receiveMessage(String message) {

    ObjectMapper objectMapper = new ObjectMapper();

    try {

      // Deserialize the JSON content string to a PurchaseRequest object
      PurchaseRequest purchaseRequest = objectMapper.readValue(message, PurchaseRequest.class);
      System.out.println("\nMensaje desencolado: " + message);

      // Getting specific properties from the deserialized JSON as a PurchaseRequest instance
      System.out.println("Monto: " + purchaseRequest.getSpecification().getAmount());
      System.out.println("Tipo de orden: " + purchaseRequest.getOrderType());

    } catch (JsonProcessingException e) {

      e.printStackTrace();
      System.err.println("Failed to parse message: " + message);

    }

  }

}
