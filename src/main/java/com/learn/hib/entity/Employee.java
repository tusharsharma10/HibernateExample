package com.learn.hib.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	private Integer id;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private EmployeeStatus empStatus;
	
	@Embedded
	private Address address;
	
	
	
	
	
	
	public Employee() {
	}
	
	
	
	public Employee(Integer id, String name, EmployeeStatus empStatus, Address address) {
		this.id = id;
		this.name = name;
		this.empStatus = empStatus;
		this.address = address;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public EmployeeStatus getEmpStatus() {
		return empStatus;
	}
	public void setEmpStatus(EmployeeStatus empStatus) {
		this.empStatus = empStatus;
	}
	
	
	
}
