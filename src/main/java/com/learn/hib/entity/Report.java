package com.learn.hib.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="REPORT")
public class Report {

	@Id
	private String reportId;
	
	private String reportName;
	
	@ManyToMany(mappedBy = "reportSet",fetch=FetchType.LAZY)
	private Set<Users> userSet = new HashSet<Users>();
	
	
	@JsonIgnore	
	public Set<Users> getUserSet() {
		return userSet;
	}
	
	
	public void addToUserSet(Users user) {
		this.userSet.add(user);
	}

	public Report(String reportId, String reportName) {
		super();
		this.reportId = reportId;
		this.reportName = reportName;
		
	}

	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	
	
	
	
}
