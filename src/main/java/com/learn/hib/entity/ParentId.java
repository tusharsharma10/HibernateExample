package com.learn.hib.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Example to show Composite primary key
 * This approach is not recommended
 */
@Embeddable
public class ParentId implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;

	public ParentId(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public ParentId() {
		super();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	// Hashcode Impl
	
	
	//Equals Impl
	
	
}
