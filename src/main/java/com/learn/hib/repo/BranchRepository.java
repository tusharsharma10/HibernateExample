package com.learn.hib.repo;

import org.springframework.data.repository.CrudRepository;

import com.learn.hib.entity.Branch;

public interface BranchRepository extends CrudRepository<Branch,Long>{

}
