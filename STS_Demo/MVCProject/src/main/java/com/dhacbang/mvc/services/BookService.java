package com.dhacbang.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dhacbang.mvc.models.Book;
import com.dhacbang.mvc.repos.BookRepo;

@Service
public class BookService {
	private final BookRepo bookRepo;
	
	public BookService(BookRepo bRepo) {
		this.bookRepo = bRepo;
	}
	
	public List<Book> getAll(){
		return bookRepo.findAll();
	}
	
	public Book getOne(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	public Book create(Book b) {
		return bookRepo.save(b);
	}
	
}
