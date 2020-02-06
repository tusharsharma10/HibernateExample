package com.learn.hib.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learn.hib.entity.Users;
@Repository
public interface UserRepo extends CrudRepository<Users, String> {

}
