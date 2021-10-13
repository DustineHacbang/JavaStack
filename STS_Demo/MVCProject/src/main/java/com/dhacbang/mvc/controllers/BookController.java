package com.dhacbang.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dhacbang.mvc.models.Book;
import com.dhacbang.mvc.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bServ;
	
	@GetMapping("/books/{bookId}")
	public String index(Model model,@PathVariable("bookId")Long bookId) {
		System.out.println(bookId);
		Book book = bServ.getOne(bookId);
		System.out.println(book);
		
		model.addAttribute("book",book);
		
		return "index.jsp";
	}

	@GetMapping("/books/allBooks")
	public String index(Model model) {
		List<Book> books = bServ.getAll();
		System.out.println(books);
		
		model.addAttribute("books",books);
		
		return "index.jsp";
	}
	
}
