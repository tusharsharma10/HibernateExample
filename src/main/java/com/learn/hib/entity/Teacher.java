package com.learn.hib.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teacher {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	
	String name;


	public Teacher(String name) {
		this.name = name;
	}


	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Long getId() {
		return id;
	}
	
	
	
}