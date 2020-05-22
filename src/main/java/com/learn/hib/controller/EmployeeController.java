package com.learn.hib.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		
		Employee e1 = new Employee(3, "Rajshekhran", EmployeeStatus.CONTRACT, a1);
		e1.addToNicknames("Raju");
		empRepo.save(e1);
		
	}
	
	
	@PutMapping("/update/employee")
	public void updateEmployee() {
		
		Optional<Employee> f1 = empRepo.findById(2);
		
		Employee e1 = f1.get();
		
		e1.addToNicknames("Raju");
		e1.addToNicknames("Rajan");
		e1.addToNicknames("Shekar");
		empRepo.save(e1);
		
	}
	
}
