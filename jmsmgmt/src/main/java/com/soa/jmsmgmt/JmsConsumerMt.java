package com.soa.jmsmgmt;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.jms.JMSException;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.fasterxml.jackson.core.JsonProcessingException;

// import com.steel.servicioacero.dto.PurchaseRequest;
// import com.steel.servicioacero.dto.OrderType;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 */
@Component
public class JmsConsumerMt implements MessageListener {

  @Autowired
  private JmsProducerMt jmsProducer;

  @Override
  public void onMessage(Message message) {

    // ObjectMapper objectMapper = new ObjectMapper();
    // PurchaseRequest purchaseRequest = null;

    try {

      if (message instanceof TextMessage) {

        String text = ((TextMessage) message).getText();

        System.out.println("\nRECEIVED MESSAGE from [amq.gerencia.in]-----\n");

        System.out.println("HEADERS-----\nDeliveryMode: " + message.getJMSDeliveryMode());
        System.out.println("Priority: " + message.getJMSPriority());
        System.out.println("TimeToLive: " + message.getJMSExpiration());
        // System.out.println("Correlation ID: " + message.getJMSCorrelationID());
        System.out.println("Type: " + message.getJMSType());

        // System.out.println("\nPROPERTIES-----\nmyProperty: " +
        // message.getStringProperty("myProperty"));

        System.out.println("\nBODY-----\nBodyJSON: " + text + "\n");

        /* 
        try {

          // Deserialize the JSON content string to a PurchaseRequest object
          purchaseRequest = objectMapper.readValue(text, PurchaseRequest.class);

        } catch (JsonProcessingException e) {

          e.printStackTrace();
          System.err.println("Failed to parse message: ");

        }
        */

        // Getting specific properties from the deserialized JSON as a PurchaseRequest instance
        // Double amount = purchaseRequest.getSpecification().getAmount();
        // OrderType orderType = purchaseRequest.getOrderType();
        
        // Send the aproved message to the [amq.compras.out] queue
        jmsProducer.sendMessage("amq.compras.out", "{\"message\":\"La solicitud de compra fue aprobada por la gerencia.\"}", 9, 60000L);
        System.out.println("\nLa solicitud de compra fue aprobada por la gerencia.");

      }

    } catch (JMSException e) {

      e.printStackTrace();
      System.err.println(e);

    }

  }

}
