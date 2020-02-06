package com.learn.hib.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learn.hib.entity.Report;
@Repository
public interface ReportRepo extends CrudRepository<Report, String> {

}
