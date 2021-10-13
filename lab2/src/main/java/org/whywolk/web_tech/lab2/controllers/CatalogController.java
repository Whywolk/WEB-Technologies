package org.whywolk.web_tech.lab2.controllers;

import org.whywolk.web_tech.lab2.service.CatalogService;
import org.whywolk.web_tech.lab2.entity.Catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class CatalogController {

	@Autowired
	CatalogService catalogService;
	
	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping("/catalog")
	public String showAllCatalog(Model model) {
		Map<String, List<Catalog>> map = Map.ofEntries(Map.entry("allItemsList", catalogService.findAll()));
		model.mergeAttributes(map);
		
		return "catalog";
	}

}
