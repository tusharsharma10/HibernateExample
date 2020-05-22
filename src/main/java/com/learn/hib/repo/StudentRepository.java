package com.learn.hib.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.hib.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{

}
