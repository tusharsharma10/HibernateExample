package com.learn.hib.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.hib.entity.Branch;
import com.learn.hib.entity.Passport;
import com.learn.hib.entity.Student;
import com.learn.hib.repo.BranchRepository;
import com.learn.hib.repo.StudentRepository;
import com.learn.hib.repo.TeacherRepository;

@RestController
public class MappingController {

	@Autowired BranchRepository branchRepo;
	@Autowired StudentRepository studentRepo;
	@Autowired TeacherRepository teacherRepo;
	
	@GetMapping("/api/branch")
	public void saveBranch() {
		
		Branch b1 = new Branch("CSE");
		Branch b2 = new Branch("ME");
		Branch b3 = new Branch("Civil");
		Branch b4 = new Branch("IT");
		Branch b5 = new Branch("EE");
		Branch b6 = new Branch("EC");
		
		List<Branch> list = new ArrayList<>(); 
		
		list.add(b1);
		list.add(b2);
		list.add(b3);
		list.add(b4);
		list.add(b5);
		list.add(b6);
		
			
			branchRepo.save(list.get(0));
			
		
		
	}
	
	
	
	@GetMapping("/api/save/student")
	public void saveStudent() {
		
		
		Student s1 = new Student("tendulakar");
		
		studentRepo.save(s1);
		
	}
	
	
	/**
	 * Branch doesn't gets added to student since 
	 * child side is adding .
	 */
	
	@GetMapping("/api/mapping/branch/student")
	public void mappingBranchStudent() {
		
		
		Optional<Student> s1 = studentRepo.findById(7L);
		Optional<Branch> b1 = branchRepo.findById(5L);
		
		
			
			b1.get().addStudent(s1.get());
			
			
				branchRepo.save(b1.get());
			
			
	}
	
	
	/**
	 * 
	 */
	
	@GetMapping("/api/mapping/student/branch")
	public void mappingStudentBranch() {
		
		
		Optional<Student> s1 = studentRepo.findById(7L);
		Optional<Branch> b1 = branchRepo.findById(5L);
		
		
			
			s1.get().setBranch(b1.get());
			
			
				studentRepo.save(s1.get());
			
			
	}
	
	
	@GetMapping("/api/getBranch")
	public void getBranch() {
		
		
		Optional<Branch> b1 = branchRepo.findById(3l);
		System.out.println(b1.get().getBranchName());
		
	}
	
	
	@GetMapping("/api/student/passport")
	public void savePassport() {
		
		Passport p1 = new Passport(212);
		
		Optional<Student> s1 = studentRepo.findById(7L);
		
		s1.get().setPassport(p1);
		
		studentRepo.save(s1.get());
	
	}
	
	
	
}
