package org.whywolk.web_tech.lab2.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.whywolk.web_tech.lab2.service.BookService;
import org.whywolk.web_tech.lab2.entity.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class BookController {

	@Autowired
	BookService bookService;
	
	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}

	@GetMapping("/contacts")
	public String index() {
		return "contacts";
	}

	@GetMapping("/books")
	public String showAllBooks(Model model) {
		Map<String, List<Book>> map = Map.ofEntries(Map.entry("allBooksList", bookService.findAll()));
		model.mergeAttributes(map);

		return "books";
	}

	@GetMapping("/book")
	public String showBook(@RequestParam(name="id", required=false) Long id, Model model) {
		Map<String, Optional<Book>> map = Map.ofEntries(Map.entry("curBook", bookService.findById(id)));
		model.mergeAttributes(map);

		return "book";
	}

	@GetMapping("/add")
	public String addBook(Model model) {
		Map<String, Book> map = Map.ofEntries(Map.entry("bookForm", new Book()));
		model.mergeAttributes(map);

		return "add";
	}

	@PostMapping("/add")
	public String addBook(@ModelAttribute("bookForm") Book bookForm, Model model) {
//		if (bookService.save(bookForm) == null)
//		{
//			model.addAttribute("booksError", "При создании книги произошла ошибка");
//			return "addOrUpdate";
//		}
		bookService.save(bookForm);
		return "redirect:/books";
	}

	@GetMapping("/update")
	public String updateBook(@RequestParam(name="id") Long id, Model model) {
		bookService.findById(id).ifPresent(book -> model.addAttribute("bookForm", book));

		return "add";
	}

	@GetMapping("/delete")
	public String deleteBook(@RequestParam(name="id") Long id, Model model) {
		bookService.findById(id).ifPresent(book -> model.addAttribute("bookForm", book));

		return "delete";
	}

	@PostMapping("/delete")
	public String deleteBook(@RequestParam(value="id") Long id)
	{
		bookService.deleteById(id);

		return "redirect:/books";
	}
}
