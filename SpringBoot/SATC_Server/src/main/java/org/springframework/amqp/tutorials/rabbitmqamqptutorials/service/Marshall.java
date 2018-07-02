package org.springframework.amqp.tutorials.rabbitmqamqptutorials.service;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.springframework.amqp.tutorials.rabbitmqamqptutorials.model.Person;
import org.springframework.amqp.tutorials.rabbitmqamqptutorials.model.Person.Sex;
import org.xml.sax.SAXException;

public class Marshall {

	public void marshaller() throws SAXException {
		try {
			Person person = new Person();
			person.setFirstName("Andy");
			person.setLastName("Warhol");
			person.setBirthDate("23 aout 2015");
			person.setChilds(1);
			person.setType(Sex.M);

			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = schemaFactory.newSchema(new File("person.xsd"));

			JAXBContext context = JAXBContext.newInstance(Person.class);
			Marshaller marshaller = context.createMarshaller();

			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			marshaller.setSchema(schema);

//			marshaller.marshal(person, System.out);
//			marshaller.marshal(person, new File("person.xml"));

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
}
