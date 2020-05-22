package com.learn.hib.repo;

import org.springframework.data.repository.CrudRepository;

import com.learn.hib.entity.Parent;
import com.learn.hib.entity.ParentId;

public interface ParentRepository extends CrudRepository<Parent,ParentId>{

}

