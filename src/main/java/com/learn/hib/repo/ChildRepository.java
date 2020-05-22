package com.learn.hib.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.hib.entity.Child;

public interface ChildRepository extends JpaRepository<Child , Long> {

}
