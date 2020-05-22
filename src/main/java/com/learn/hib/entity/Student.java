package com.learn.hib.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Student {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	
	String name;
	
	@ManyToOne(cascade=CascadeType.REMOVE, fetch=FetchType.LAZY)
	@JoinColumn(name="branchid")
	Branch branch;
	
	
	@ManyToMany(cascade=CascadeType.REMOVE)
	Set<Teacher> teacherSet = new HashSet<Teacher>();


	@OneToOne(cascade = {CascadeType.PERSIST , CascadeType.REMOVE})
	Passport passport;
	
	


	public Passport getPassport() {
		return passport;
	}


	public void setPassport(Passport passport) {
		this.passport = passport;
	}


	public Student(String name) {
		this.name = name;
	}


	public Student(String name, Branch branch) {
		this.name = name;
		this.branch = branch;
	}


	public Student(String name, Branch branch, Set<Teacher> teacherSet) {
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


//	//  equals Method
//	@Override
//	public boolean equals(Object obj) {
//		
//		if(!(obj instanceof Student))
//			return false;
//		
//		Student other = (Student)obj;
//		return new EqualsBuilder().append(id,other.id).isEquals();
//		
//		
//	}

	
	// hashcode method
//	@Override
//	public int hashCode() {
//		
//		return new HashCodeBuilder().append(id).toHashCode();
//		
//	}
	
	
	
	
	
	
	
}
