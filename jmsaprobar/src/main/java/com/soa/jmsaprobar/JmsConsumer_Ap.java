package com.soa.jmsaprobar;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.steel.servicioacero.dto.PurchaseRequest;
import com.steel.servicioacero.dto.OrderType;

@Component
public class JmsConsumer_Ap {

  @JmsListener(destination = "compras.in")
  public void receiveMessage(String message) {

    ObjectMapper objectMapper = new ObjectMapper();

    try {

      // Deserialize the JSON content string to a PurchaseRequest object
      PurchaseRequest purchaseRequest = objectMapper.readValue(message, PurchaseRequest.class);
      System.out.println("\nMensaje desencolado: " + message);

      // Getting specific properties from the deserialized JSON as a PurchaseRequest
      // instance
      Double amount = purchaseRequest.getSpecification().getAmount();
      OrderType orderType = purchaseRequest.getOrderType();

      // Applying the conditions required
      if (amount <= 100000 && orderType == OrderType.Normal) {

        System.out.println("La solicitud de compra fue aprobada");

      } else if (amount > 100000 && orderType == OrderType.Normal) {

        System.out.println("La solicitud de compra sera revisada por la gerencia");

      } else if (orderType == OrderType.Urgent) {

        System.out.println("La solicitud de compra sera revisada por la gerencia");

      } else {

        System.out.println("La solicitud de compra fue rechazada");

      }

    } catch (JsonProcessingException e) {

      e.printStackTrace();
      System.err.println("Failed to parse message: " + message);

    }

  }

}
