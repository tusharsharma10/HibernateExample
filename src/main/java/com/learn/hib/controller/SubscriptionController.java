package com.learn.hib.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	public void addUsers(@PathVariable String authId, @PathVariable String name) {

		Users u1 = new Users(authId, name);
		userRepo.save(u1);
	}

	@GetMapping("/add/reports")
	public void addreports() {

		String repId[] = { "Bamboo_Plan", "Sonar_commit", "RPM_List", "Jira_Report" };
		String repName[] = { "Bamboo Plan", "Sonar Commit", "RPM List", "Jira Report" };

		for (int i = 0; i <= 3; i++) {

			Report r1 = new Report(repId[i], repName[i]);
			reportRepo.save(r1);

		}

	}

	@GetMapping("/subscribe")
	public void addSubscription() {

		Iterable<Users> users = userRepo.findAll();
		Iterable<Report> reports = reportRepo.findAll();

		for (Users u : users) {

			for (Report r : reports) {

				u.addToReportSet(r);
				r.addToUserSet(u);

				userRepo.save(u);
			}
		}
	}
	
	@GetMapping("getSubscriptionReports/{authId}")
	public Set<Report> getSubscriptionOfUser(@PathVariable String authId) {
		
		Set<Report> reportSet= new HashSet<Report>();
		
		reportSet =  userRepo.findById(authId).get().getReportSet();
		
		
		return reportSet;
		
	}
	
	@GetMapping("getUsersForReport/{reportId}")
	public Set<Users> getUserForReport(@PathVariable String reportId) {
		
		Set<Users> userSet= new HashSet<Users>();
		
		userSet = reportRepo.findById(reportId).get().getUserSet();
		
		
		return userSet;
		
	}
	
	@DeleteMapping("remove/userSubscription/{authId}/{reportId}")
	public void removeSubscription(@PathVariable String authId, @PathVariable String reportId) {
		
		Users u = userRepo.findById(authId).get();
		Report r = reportRepo.findById(reportId).get();
		
		if(u.getReportSet().contains(r))
			u.getReportSet().remove(r);
		
		if(r.getUserSet().contains(u))
			r.getUserSet().remove(u);
		
		userRepo.save(u);
		
	}
	

}
