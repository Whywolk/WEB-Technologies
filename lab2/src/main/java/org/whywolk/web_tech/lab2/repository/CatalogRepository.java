package org.whywolk.web_tech.lab2.repository;

import org.whywolk.web_tech.lab2.entity.Catalog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CatalogRepository extends JpaRepository<Catalog, Long> {

	@Override
	List<Catalog> findAll();
	
	@Override
	Optional<Catalog> findById(Long id);
	
	@Query(value = "SELECT * FROM catalog WHERE catalog.category = :category", nativeQuery = true)
	List<Catalog> findAllByCategory(@Param("category") String category);
	
	

}