package com.learn.hib.repo;

import org.springframework.data.repository.CrudRepository;

import com.learn.hib.entity.Student;

public interface StudentRepository extends CrudRepository<Student,Long>{

}
