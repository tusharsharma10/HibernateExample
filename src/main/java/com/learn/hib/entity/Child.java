package com.learn.hib.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Entity
public class Child {

	
	@Id
	Long id;
	
	String name;
	
	Integer age;

	public Child() {
	}

	// owner of the association since Many side
	@ManyToOne
	@JoinColumns({
			
			@JoinColumn(name="firstname_fk",referencedColumnName="firstname"),
			@JoinColumn(name="lastname_fk",referencedColumnName="lastname")
			
	})
	Parent parent;

	public Child(Long id, String name, Integer age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}




	public Parent getParent() {
		return parent;
	}




	public void setParent(Parent parent) {
		this.parent = parent;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	
}
