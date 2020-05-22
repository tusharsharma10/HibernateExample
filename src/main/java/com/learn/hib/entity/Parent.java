package com.learn.hib.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Parent {

	
	@EmbeddedId
	ParentId id;
	
	Integer age;

	public Parent() {
	}

	public Parent(ParentId id, Integer age) {
		this.id = id;
		this.age = age;
	}

	public ParentId getId() {
		return id;
	}

	public void setId(ParentId id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	
}
