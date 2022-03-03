package com.RestApiDev.first.service;

import java.util.List;

import com.RestApiDev.first.model.Product;

public interface productService {

	Product createProduct(Product product);
	Product updateProduct(Product product);
	List<Product> getAllProducts();
	Product getProductById(long ProductId);
	void deleteProduct(long id);
}
