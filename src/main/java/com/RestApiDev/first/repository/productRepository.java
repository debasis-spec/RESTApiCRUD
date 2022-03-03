package com.RestApiDev.first.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RestApiDev.first.model.Product;

public interface productRepository extends JpaRepository<Product, Long> {

}
