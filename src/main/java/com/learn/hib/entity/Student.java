package com.learn.hib.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Student {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	
	String name;
	
	@ManyToOne
	@JoinColumn(name="branchid")
	Branch branch;
	
	
	@ManyToMany
	Set<Teacher> teacherSet = new HashSet<Teacher>();


	


	public Student(String name) {
		super();
		this.name = name;
	}


	public Student(String name, Set<Teacher> teacherSet) {
		super();
		this.name = name;
		this.teacherSet = teacherSet;
	}


	public Student(String name, Branch branch, Set<Teacher> teacherSet) {
		super();
		this.name = name;
		this.branch = branch;
		this.teacherSet = teacherSet;
	}


	public Student() {
		super();
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Branch getBranch() {
		return branch;
	}


	public void setBranch(Branch branch) {
		this.branch = branch;
	}


	


	public Set<Teacher> getTeacherSet() {
		return teacherSet;
	}


	public void setTeacherSet(Set<Teacher> teacherSet) {
		this.teacherSet = teacherSet;
	}


	public Long getId() {
		return id;
	}
	
	
	
	
}
