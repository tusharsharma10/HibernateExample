package com.learn.hib.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.hib.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {

}
