package com.SpringBootJPA.Example;

import org.springframework.data.jpa.repository.JpaRepository;

interface ProductRepository extends JpaRepository<Product, Integer> {

	Product findByName(String name);
	

}
