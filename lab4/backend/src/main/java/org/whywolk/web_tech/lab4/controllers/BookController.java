// License: GNU GPL version 3 <https://www.gnu.org/licenses/gpl-3.0.html>
// Copyright (C) 2021  Author: Alex Shirshov <https://github.com/Whywolk>

package org.whywolk.web_tech.lab4.controllers;

import org.whywolk.web_tech.lab4.service.BookNotFoundException;
import org.whywolk.web_tech.lab4.service.BookService;
import org.whywolk.web_tech.lab4.entity.Book;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8079")
@RestController
@RequestMapping("api")
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping("/books")
	public List<Book> getBooks() {
		return bookService.findAll();
	}

	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable(name="id") Long id) {
		return bookService.findById(id)
				.orElseThrow(() -> new BookNotFoundException(id));
	}

	@PostMapping("/books")
	public Book addBook(@RequestBody Book newBook) {
		return bookService.save(newBook);
	}

	@PutMapping("/book/{id}")
	public Book updateBook(@RequestBody Book newBook, @PathVariable(name="id") Long id) {
		return bookService.findById(id)
				.map(book -> {
					book.setTitle(newBook.getTitle());
					book.setAuthor(newBook.getAuthor());
					book.setDescription(newBook.getDescription());
					return bookService.save(book);
				})
				.orElseGet(() -> {
					newBook.setId(id);
					return bookService.save(newBook);
				});
	}

	@DeleteMapping("/book/{id}")
	public void deleteBook(@PathVariable(name="id") Long id) {
		bookService.deleteById(id);
	}
}
