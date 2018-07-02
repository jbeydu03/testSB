package org.springframework.amqp.tutorials.rabbitmqamqptutorials.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Horloge")
public class Horloge {

	private long heure;

	public Horloge() {
	}

	public long getHeure() {
		return heure;
	}
	
	@XmlAttribute(name="heure", required=true)
	public void setHeure(long heure) {
		this.heure = heure;
	}

	@Override
	public String toString() {
		return "Horloge [heure=" + heure + "]";
	}

}
