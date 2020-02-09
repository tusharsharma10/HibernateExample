package com.learn.hib.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learn.hib.entity.Users;
@Repository
public interface UserRepo extends CrudRepository<Users, String> {
	
	@Transactional
	@Modifying 
	@Query(value="delete from User_Subscription where fk_auth_id = :authId and fk_report_id = :reportId" , nativeQuery=true)
	void removeUser(@Param("authId")String authId,@Param("reportId")String reportId);
	
	
	
	
}
