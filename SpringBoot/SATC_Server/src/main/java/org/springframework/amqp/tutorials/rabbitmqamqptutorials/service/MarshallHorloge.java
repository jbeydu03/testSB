package org.springframework.amqp.tutorials.rabbitmqamqptutorials.service;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.springframework.amqp.tutorials.rabbitmqamqptutorials.model.Horloge;
import org.springframework.amqp.tutorials.rabbitmqamqptutorials.model.Person;
import org.springframework.amqp.tutorials.rabbitmqamqptutorials.model.Person.Sex;
import org.xml.sax.SAXException;

public class MarshallHorloge {

	public void marshaller() throws SAXException {
		try {
			Horloge h = new Horloge();
			h.setHeure(123);
			

			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = schemaFactory.newSchema(new File("horloge.xsd"));

			JAXBContext context = JAXBContext.newInstance(Horloge.class);
			Marshaller marshaller = context.createMarshaller();

			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			marshaller.setSchema(schema);

			marshaller.marshal(h, System.out);
			marshaller.marshal(h, new File("horloge.xml"));

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
}
