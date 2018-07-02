package org.springframework.amqp.tutorials.rabbitmqamqptutorials.hello;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.tutorials.rabbitmqamqptutorials.RabbitmqAmqpTutorialsApplication;
import org.springframework.amqp.tutorials.rabbitmqamqptutorials.model.CustomMessage;
import org.springframework.amqp.tutorials.rabbitmqamqptutorials.service.Marshall;
import org.springframework.amqp.tutorials.rabbitmqamqptutorials.service.MarshallHorloge;
import org.springframework.amqp.tutorials.rabbitmqamqptutorials.service.Unmarshall;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    public Runner(Receiver receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
//        System.out.println("Sending message...");
//        MarshallHorloge m = new MarshallHorloge();
//        m.marshaller();
        
//        Unmarshall un = new Unmarshall();
//        un.unmarshaller();
    
        CustomMessage cm = new CustomMessage("un test", 1, true);
        rabbitTemplate.convertAndSend(RabbitmqAmqpTutorialsApplication.topicExchangeName, "foo.bar.baz", cm);
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }

}