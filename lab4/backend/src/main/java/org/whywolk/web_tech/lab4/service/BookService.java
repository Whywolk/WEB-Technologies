package org.whywolk.web_tech.lab4.service;

import org.whywolk.web_tech.lab4.entity.Book;
import org.whywolk.web_tech.lab4.repository.BookRepository;

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
