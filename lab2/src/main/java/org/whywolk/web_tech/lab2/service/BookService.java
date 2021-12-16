// License: GNU GPL version 3 <https://www.gnu.org/licenses/gpl-3.0.html>
// Copyright (C) 2021  Author: Alex Shirshov <https://github.com/Whywolk>

package org.whywolk.web_tech.lab2.service;

import org.whywolk.web_tech.lab2.entity.Book;
import org.whywolk.web_tech.lab2.repository.BookRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Autowired
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book> findAll() {
		return bookRepository.findAll();
	}
	
	public Optional<Book> findById(Long catalogId) {
		return bookRepository.findById(catalogId);
	}

	public void deleteById(Long id) {
		if (bookRepository.findById(id).isPresent()) {
			bookRepository.deleteById(id);
		}
	}

	public Book save(Book book)
	{
		return bookRepository.save(book);
	}
}
