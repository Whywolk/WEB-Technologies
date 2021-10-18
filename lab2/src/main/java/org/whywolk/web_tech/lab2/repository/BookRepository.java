package org.whywolk.web_tech.lab2.repository;

import org.whywolk.web_tech.lab2.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

	@Override
	List<Book> findAll();
	
	@Override
	Optional<Book> findById(Long id);

	@Override
	void deleteById(Long id);

	@Override
	Book save(Book book);
}