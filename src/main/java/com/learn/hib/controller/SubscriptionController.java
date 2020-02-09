package com.learn.hib.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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

	/**
	 * DB filler method to add users in user table
	 * 
	 * @param authId
	 * @param name
	 */

	@GetMapping("/add/users")
	public void addUsers() {

		Map<String, String> userMap = new HashMap<String, String>();
		userMap.put("tsharmmx", "Tushar Sharma");
		userMap.put("dsharm7m", "Deepak Sharma");
		userMap.put("asharmwn", "Akanksha Sharma");
		userMap.put("okhan2z", "Osama Khan");
		userMap.put("thussaid", "Tanveer Hussain");
		userMap.put("pvarshdx", "Praval Varshney");
		userMap.put("agole3r", "Anjali Gole");

		userMap.keySet().forEach(k -> {

			Users u1 = new Users(k, userMap.get(k));
			userRepo.save(u1);

		});

	}

	/**
	 * Db filler method controller to add reports
	 */
	@GetMapping("/add/reports")
	public void addreports() {

		String repId[] = { "Bamboo_Plan", "Sonar_commit", "RPM_List", "Jira_Report" };
		String repName[] = { "Bamboo Plan", "Sonar Commit", "RPM List", "Jira Report" };

		for (int i = 0; i <= 3; i++) {

			Report r1 = new Report(repId[i], repName[i]);
			reportRepo.save(r1);

		}

	}

	/**
	 * DB filler method controller subscribes all users to all reports.
	 */
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

	@PutMapping("/subscribe/{authId}/{reportId}")
	public void subscribeToReport(@PathVariable String authId, @PathVariable String reportId) {

		Users u = userRepo.findById(authId).get();
		Report r = reportRepo.findById(reportId).get();

		u.addToReportSet(r);
		r.addToUserSet(u);
		userRepo.save(u);
	}

	/**
	 * Gets subscribed reports corresponding to user
	 * 
	 * @param authId
	 * @return
	 */
	@GetMapping("getSubscriptionReports/{authId}")
	public Set<Report> getSubscriptionOfUser(@PathVariable String authId) {

		Set<Report> reportSet = new HashSet<Report>();

		reportSet = userRepo.findById(authId).get().getReportSet();

		return reportSet;

	}

	/**
	 * Gets users corresponding to a report subscribed by them
	 * 
	 * @param reportId
	 * @return
	 */
	@GetMapping("getUsersForReport/{reportId}")
	public Set<Users> getUserForReport(@PathVariable String reportId) {

		Set<Users> userSet = new HashSet<Users>();

		userSet = reportRepo.findById(reportId).get().getUserSet();

		return userSet;

	}

	/**
	 * Removes user subscription for a report
	 * 
	 * @param authId
	 * @param reportId
	 */
	@DeleteMapping("remove/userSubscription/{authId}/{reportId}")
	public void removeSubscription(@PathVariable String authId, @PathVariable String reportId) {

		Users u = userRepo.findById(authId).get();
		Report r = reportRepo.findById(reportId).get();

		if (u.getReportSet().contains(r))
			u.getReportSet().remove(r);

		if (r.getUserSet().contains(u))
			r.getUserSet().remove(u);

		userRepo.save(u);

	}

	/**
	 * Lazy loading checker
	 */
	@GetMapping("lazy/check")
	public Iterable<Users> getAllUsers() {

		Iterable<Users> userList = userRepo.findAll();
		System.out.println("Lazy fetch");
		return userList;

	}

	/**
	 * Deleting subscription with query
	 */
	@DeleteMapping("remove/query/{authId}/{reportId}")
	public void removeSubscriptionByQuery(@PathVariable String authId, @PathVariable String reportId) {
			
		userRepo.removeUser(authId, reportId);
		
	}

}
