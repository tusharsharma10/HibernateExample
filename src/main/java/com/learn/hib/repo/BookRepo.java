package com.learn.hib.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learn.hib.entity.Book;


public interface BookRepo extends CrudRepository<Book,Integer>{

}
