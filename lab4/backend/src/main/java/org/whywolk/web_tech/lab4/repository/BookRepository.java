package org.whywolk.web_tech.lab4.repository;

import org.springframework.stereotype.Repository;
import org.whywolk.web_tech.lab4.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
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