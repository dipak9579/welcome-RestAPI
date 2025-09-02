package com.dipak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dipak.entity.Book;
import com.dipak.repo.BookRepo;

@RestController
public class BookController {
	
	@Autowired
	private BookRepo repo;
	
	@PostMapping("/add")
	public String addBook(@RequestBody Book book) {
		Book save = repo.save(book);
		System.out.println(save);
		return "Book added successfully";
	}
	
	@GetMapping("/books")
	public List<Book>getAllBook(){
		return repo.findAll();
	}

}
