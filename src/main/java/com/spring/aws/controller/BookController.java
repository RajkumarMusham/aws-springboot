package com.spring.aws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.SneakyThrows;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookRepository bookRepo;
	
	@PostMapping
	public Book saveBook(@RequestBody Book book) {
		System.out.println("book =>"+book);
		return bookRepo.save(book);
	}
	
	@GetMapping
	public List<Book> fetchAllBooks() {
		return bookRepo.findAll();
	}
	
	@SneakyThrows
	@GetMapping("/{id}")
	public Book fetchAllBooksById(@PathVariable int id) throws Exception {
		Book book = bookRepo.findById(id).orElseThrow(() -> new Exception("Book not found"));
		return book;
	}
	
	@GetMapping("/delelte")
	public void deleteAllBooks() {
		bookRepo.deleteAll();
	}
	
	@SneakyThrows
	@GetMapping("/delelte/{id}")
	public void deleteBookById(@PathVariable int id)  throws Exception{
		bookRepo.deleteById(id);
	}
}
