package com.RestApiDev.first.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestApiDev.first.exception.resourceNotFoundException;
import com.RestApiDev.first.model.Product;
import com.RestApiDev.first.repository.productRepository;

@Service
@Transactional
public class productserviceImpl implements productService{
	@Autowired
	private productRepository productrepository;

	@Override
	public Product createProduct(Product product) {
		return productrepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		Optional<Product> productDb = this.productrepository.findById(product.getId()); //We fetch the data from DB
		
		if(productDb.isPresent()) {
			Product productUpdate = productDb.get(); //We want to get obj from optional if product is present.
			productUpdate.setId(product.getId());
			productUpdate.setName(product.getName());
		productrepository.save(productUpdate); // The updated values saved in repo
		return productUpdate;
		}
		else {
			throw new resourceNotFoundException("The record is not found  by id " + product.getId());
		}
	}

	@Override
	public List<Product> getAllProducts() {
		return this.productrepository.findAll();
	}

	@Override
	public Product getProductById(long ProductId) {
		Optional<Product> productDb = this.productrepository.findById(ProductId);
		
		if(productDb.isPresent()) {
			return productDb.get();
		}
		else {
			throw new resourceNotFoundException("The record is not found  by id " + ProductId);
		}
		
		
	}

	@Override
	public void deleteProduct(long ProductId) {
		Optional<Product> productDb = this.productrepository.findById(ProductId);
		if(productDb.isPresent()) {
		
			this.productrepository.delete(productDb.get());
	}
		else {
			throw new resourceNotFoundException("The record is not found  by id " + ProductId);
		}
	}

}
