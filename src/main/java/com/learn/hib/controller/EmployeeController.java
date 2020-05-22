package com.learn.hib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.hib.entity.Address;
import com.learn.hib.entity.Employee;
import com.learn.hib.entity.EmployeeStatus;
import com.learn.hib.repo.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired EmployeeRepository empRepo;
	
	@PostMapping("/save/employee")
	public void saveEmployee() {
		
		Address a1 = new  Address("Bijolia", "Rajasthan", "India", 1000000);
		
		Employee e1 = new Employee(2, "Rajshekhran", EmployeeStatus.CONTRACT, a1);
		
		empRepo.save(e1);
		
	}
	
}
