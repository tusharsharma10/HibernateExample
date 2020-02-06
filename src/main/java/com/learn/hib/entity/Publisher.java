package com.learn.hib.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Publisher {

	
	private String name;

	
	private String country;

	//Getters and setters, equals and hashCode methods omitted for brevity

}