package com.learn.hib.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	
	Integer number;

	@OneToOne(mappedBy="passport")
	Student student;

	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public Passport(Integer number) {
		this.number = number;
	}


	public Passport() {
	}


	public Integer getNumber() {
		return number;
	}


	public void setNumber(Integer number) {
		this.number = number;
	}


	public Long getId() {
		return id;
	}
	
	
	
	
	
}