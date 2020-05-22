package com.learn.hib.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Employee {

	@Id
	private Integer id;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private EmployeeStatus empStatus;
	
	@Embedded
	private Address address;
	
	@ElementCollection
	@CollectionTable(name="nickname", joinColumns = @JoinColumn(name="emp_id"))
	@Column(name="nickname")
	private Set<String> nicknames = new HashSet<String>();
	
	
	
	public Set<String> getNicknames() {
		return nicknames;
	}



	public void addToNicknames(String nickname) {
		
		this.nicknames.add(nickname);
	}



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
