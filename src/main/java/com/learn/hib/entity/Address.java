package com.learn.hib.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;


public class Address implements Serializable {

	
	private static final long serialVersionUID = 1L;
	String city;
	String state;
	String country;
	Integer pincode;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	
	
	
	
	
}
