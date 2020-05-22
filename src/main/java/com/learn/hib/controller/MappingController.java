package com.learn.hib.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.annotations.BatchSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
	/**
	 * Returns true even if equals and 
	 * hashcode not implemented since 1 level caching caches 
	 * s1 object
	 */
	
	@GetMapping("/student/branch")
	public void checkStudents() {
		
		Optional<Student> s1 = studentRepo.findById(7L);
		
		Optional<Branch> b1 = branchRepo.findById(5L);
		
		Set<Student> set = b1.get().getStudentSet();
		
		System.out.println(set.contains(s1.get()));
		
	}
	
	
	/**
	 * Checking Performance with Eager fetching, lazy 
	 * and batch size
	 * By default - Many TO One and One to One - Eagerly Fetched
	 * One TO Many and Many TO Many Lazy fetched
	 * 
	 * i.e is if a Entity has a collection entity mapping then - Lazy Fetched
	 */
	
	/*
	 * Task just Printing Student name.
	 * With both Eager and Lazy Fetch
	 */
	
	@GetMapping("/print/student")
	public List<String> printStudent() {
		
		List<Student> list =  studentRepo.findAll(); 
		List<String> names = new ArrayList<String>();
		
		list.parallelStream().forEach(l->{
			
			
			names.add(l.getName());
			
		});
		
		return names;
	}
	
	
	
	/*
	 * Task  Printing Student and branch name.
	 * Using BatchSize
	 * Only use stream parallelStream is dangerous to use
	 */
	
	@GetMapping("/print/student/branch")
	@BatchSize(size=10)
	public List<String> printStudBranch() {
		
		List<Student> list =  studentRepo.findAll(); 
		List<String> names = new ArrayList<String>();
		
		list.stream().forEach(l->{
			
			String x = "Name: "+ l.getName()+" Branch Name: "+l.getBranch().getBranchName();
			names.add(x);
			
		});
		
		return names;
	}
	
	
	
	
	
	
	
	@PostMapping("/add/students")
	public void addStudents() throws IOException {
		
		  List<String> names =  getNames();
		
		  Iterable<Branch> itr = branchRepo.findAll();
		  
		  List<Branch> brlist = new ArrayList<Branch>();
		  
		  itr.forEach(i->{
			  
			  brlist.add(i);
			  
		  });
		  

		  names.forEach(n->{
			  
			  Student s = new Student(n);
			  
			  Random r = new Random();
			  
			  s.setBranch(brlist.get(r.nextInt(5)));
			  
			  studentRepo.save(s);
		  });
		  
		 
	}
	
	
	private List<String> getNames() throws IOException {
		
		
		List<String> list = new ArrayList<String>();
		
		FileReader in =  new FileReader("bin/names.txt");
		BufferedReader br = new BufferedReader(in);	
		
		Scanner sc = new Scanner(in);
		
		while(sc.hasNext()) {
			
			list.add(sc.next());
		}
		
		 sc.close();    
         in.close();  
         
         return list ;
	}
	
	
	
}
