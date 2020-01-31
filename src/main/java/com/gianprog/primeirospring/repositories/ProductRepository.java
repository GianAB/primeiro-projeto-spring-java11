package com.gianprog.primeirospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gianprog.primeirospring.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
