package org.whywolk.web_tech.lab2.entity;

import javax.persistence.*;

@Entity
@Table(name = "catalog")
public class Catalog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	private String name;
	
	@Column
	private Long price;
	
	@Column
	private String category;
	
	@Column
	private String img_src;
	
	public Catalog() {}
	
	public Catalog(Long id, String name, Long price, String category, String img_src) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.img_src = img_src;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImg_src() {
		return img_src;
	}

	public void setImg_src(String img_src) {
		this.img_src = img_src;
	}
	
	
	
	
}
