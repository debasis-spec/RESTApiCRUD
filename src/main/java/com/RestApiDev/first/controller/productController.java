package com.RestApiDev.first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.RestApiDev.first.model.Product;
import com.RestApiDev.first.service.productService;

@RestController
public class productController {

	@Autowired
	private productService productservice;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProduct(){
		return ResponseEntity.ok().body(productservice.getAllProducts());
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity <Product> getProductById(@PathVariable long id){
		return ResponseEntity.ok().body(productservice.getProductById(id)); // Read part
	}
	
	
	@PostMapping("/products")
		public ResponseEntity<Product> createProduct(@RequestBody Product product){
		return ResponseEntity.ok().body(this.productservice.createProduct(product)); // Create part
		}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product product){
		product.setId(id);
		return ResponseEntity.ok().body(this.productservice.updateProduct(product)); //Update part
		
	}
	@DeleteMapping("/products/{id}")
	public HttpStatus deleteProduct(@PathVariable long id){
		this.productservice.deleteProduct(id);
		return HttpStatus.OK; //Delete part
	}
	
}
