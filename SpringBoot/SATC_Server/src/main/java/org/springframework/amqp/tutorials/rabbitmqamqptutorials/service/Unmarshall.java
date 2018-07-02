package org.springframework.amqp.tutorials.rabbitmqamqptutorials.service;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.amqp.tutorials.rabbitmqamqptutorials.model.Horloge;
import org.springframework.amqp.tutorials.rabbitmqamqptutorials.model.Person;



public class Unmarshall {

	public void unmarshaller() throws JAXBException {
		try {
		File file = new File("horloge3.xml");
		JAXBContext jaxbContext= JAXBContext.newInstance(Horloge.class); ;
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Horloge e = (Horloge) jaxbUnmarshaller.unmarshal(file);
		System.out.println(e.toString());

		
		
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
