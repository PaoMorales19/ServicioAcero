package com.soa.jmsaprobar;

// import javax.jms.ConnectionFactory;
// import javax.jms.Connection;
// import javax.jms.Session;
// import javax.jms.Destination;
// import javax.jms.MessageProducer;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.QosSettings;
import org.springframework.jms.core.MessagePostProcessor;

@Component
public class JmsProducerAp {

  @Autowired
  private JmsTemplate jmsTemplate;

  public void sendMessage(String destinationName, String text, int priority, long timeToLive) {

    jmsTemplate.setExplicitQosEnabled(true);
    jmsTemplate.setQosSettings(new QosSettings(DeliveryMode.NON_PERSISTENT, priority, timeToLive));

    jmsTemplate.convertAndSend(destinationName, text, new MessagePostProcessor() {

      @Override
      public Message postProcessMessage(Message msg) throws JMSException {

        // msg.setJMSCorrelationID("unique-id-123");
        msg.setJMSType("application/json");

        // msg.setStringProperty("myProperty", "holaMundo");

        return msg;

      }

    });

    System.out.println("Sent message: " + text);

  }

}