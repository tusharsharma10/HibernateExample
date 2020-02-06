package com.learn.hib.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class Users {

	@Id
	private String authId;
	
	private String name;
	
	@ManyToMany(cascade= {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch=FetchType.LAZY)
	private Set<Report> reportSet = new HashSet<Report>();

	public Users(String authId, String name) {
		super();
		this.authId = authId;
		this.name = name;
		
	}

	public String getAuthId() {
		return authId;
	}

	public void setAuthId(String authId) {
		this.authId = authId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Report> getReportSet() {
		return reportSet;
	}

	public void addToReportSet(Report report) {
		this.reportSet.add(report);
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
