package org.springframework.amqp.tutorials.rabbitmqamqptutorials.hello;

import java.util.concurrent.CountDownLatch;

import org.springframework.amqp.tutorials.rabbitmqamqptutorials.model.CustomMessage;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(CustomMessage cm) {
        System.out.println("Received <" + cm.toString() + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}