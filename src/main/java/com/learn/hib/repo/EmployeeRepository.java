package com.learn.hib.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.hib.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
