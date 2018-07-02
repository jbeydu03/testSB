package org.springframework.amqp.tutorials.rabbitmqamqptutorials.model;

import java.time.LocalDate;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlType(propOrder={"firstName", "lastName", "childs", "birthDate"})
@XmlRootElement(name = "person")
public class Person {
	String firstName;
	String lastName;
	String birthDate;
	int childs;
	
	public enum Sex{M,F}
	
	Sex type;

	public String getFirstName() {
		return firstName;
	}

	@XmlElement(name = "firstName")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@XmlElement(name = "lastName")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	@XmlElement(name = "birthDate")
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public int getChilds() {
		return childs;
	}

	@XmlElement(name = "childs")
	public void setChilds(int childs) {
		this.childs = childs;
	}
	
	public Sex getType() {
		return type;
	}
	
	@XmlAttribute(name="sex")
	public void setType(Sex type) {
		this.type = type;
	}

}
