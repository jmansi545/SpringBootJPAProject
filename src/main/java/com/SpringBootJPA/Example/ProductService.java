package com.SpringBootJPA.Example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	//to save single product
	public Product  saveProduct(Product product) {
		return repository.save(product);
	}

	//to save list of products
	public List<Product> saveProducts(List<Product> products){
		return repository.saveAll(products);
	}

	//to fetch the all products
	public List<Product> getProducts(){
		return repository.findAll();
	}

	//to fetch by id product
	public Product getProductById(int id) {
		return repository.findById(id).orElse(null);
	}

	//to fetch by name product
	public Product getProductByName(String name) {
		return repository.findByName(name);
	}

	public String deleteProduct(int id) {
		repository.deleteById(id);
		return "Product removed Succefully!! " +id;
	}

	public Product updateProduct(Product product) {
		Product existingProduct = repository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());
		return repository.save(existingProduct);
	}
}
