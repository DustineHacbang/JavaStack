package com.dhacbang.mvc.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dhacbang.mvc.models.Book;

@Repository
public interface BookRepo extends CrudRepository<Book, Long> {
	List<Book> findAll();

}
