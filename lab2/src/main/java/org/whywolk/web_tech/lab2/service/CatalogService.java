package org.whywolk.web_tech.lab2.service;

import org.whywolk.web_tech.lab2.entity.Catalog;
import org.whywolk.web_tech.lab2.repository.CatalogRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogService {

	@Autowired
	private final CatalogRepository catalogRepository;
	
	public CatalogService(CatalogRepository catalogRepository) {
		this.catalogRepository = catalogRepository;
	}
	
	public List<Catalog> findAll() {
		return catalogRepository.findAll();
	}
	
	public Optional<Catalog> findById(Long catalogId) {
		return catalogRepository.findById(catalogId);
	}
	
	public List<Catalog> findAllByCategory(String category) {
		return catalogRepository.findAllByCategory(category);
	}
}
