package com.learn.hib.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Branch {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	
	String branchName;


	public Branch(String branchName) {
		super();
		this.branchName = branchName;
	}

	
	@OneToMany(mappedBy="branch")
	Set<Student> studentSet = new HashSet<Student>();
	

	public Set<Student> getStudentSet() {
		return studentSet;
	}


	public void setStudentSet(Set<Student> studentSet) {
		this.studentSet = studentSet;
	}

	
	public void addStudent(Student s) {
		
		studentSet.add(s);
		
	}
	

	public Branch() {
	}


	public String getBranchName() {
		return branchName;
	}


	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}


	public Long getId() {
		return id;
	}
	
	
	
}

