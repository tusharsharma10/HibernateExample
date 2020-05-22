package com.learn.hib.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.hib.entity.Child;
import com.learn.hib.entity.Parent;
import com.learn.hib.entity.ParentId;
import com.learn.hib.repo.ChildRepository;
import com.learn.hib.repo.ParentRepository;

@RestController
public class ParentController {

	@Autowired ParentRepository parRepo;
	@Autowired ChildRepository chiRepo;
	
	@PostMapping("/save/parent")
	public void saveParent() {
		
		ParentId id = new ParentId("Chris", "Ronaldo");
		
		Parent p1 = new Parent(id, 45);
		
		parRepo.save(p1);
	}
	
	
	@PostMapping("/save/child")
	public void saveChild() {
		
		Child c1 = new Child(4L, "Travis", 20);
		ParentId id = new ParentId("Chris", "Ronaldo");
		
		Optional<Parent> opt1 = parRepo.findById(id);		
		
		Parent p1 = opt1.get();
		
		c1.setParent(p1);
		
		chiRepo.save(c1);
		
	}
	
}
