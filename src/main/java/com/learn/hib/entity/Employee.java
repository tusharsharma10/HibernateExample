package com.learn.hib.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;


public class Employee {

	@Id
	Integer id;
	String name;
	Integer age;
	
	Address address;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
