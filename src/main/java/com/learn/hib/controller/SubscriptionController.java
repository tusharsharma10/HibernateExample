package com.learn.hib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.learn.hib.entity.Report;
import com.learn.hib.entity.Users;
import com.learn.hib.repo.ReportRepo;
import com.learn.hib.repo.UserRepo;

@RestController
public class SubscriptionController {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ReportRepo reportRepo;
	
	@GetMapping("/add/{authId}/{name}")
	public void addUsers(@PathVariable String authId,@PathVariable String name) {
		
		Users u1 = new Users(authId, name);
		userRepo.save(u1);
	}
	
	
	@GetMapping("/add/reports")
	public void addreports() {
		
		String repId[] = {"Bamboo_Plan","Sonar_commit","RPM_List","Jira_Report"}; 
		String repName[] = {"Bamboo Plan","Sonar Commit","RPM List","Jira Report"}; 
		
		for(int i=0;i<=3;i++) {
			
			Report r1 = new Report(repId[i], repName[i]);
			reportRepo.save(r1);
			
		}
		
	}
	
	
	@GetMapping("/subscribe")
	public void addSubscription() {
		
		Iterable<Users> users = userRepo.findAll();
		Iterable<Report> reports = reportRepo.findAll();
		
		for(Users u:users) {
		
			for(Report r:reports) {
			
		u.addToReportSet(r);
		r.addToUserSet(u);
		
		userRepo.save(u);
			}
		}
	}
	
	
}
