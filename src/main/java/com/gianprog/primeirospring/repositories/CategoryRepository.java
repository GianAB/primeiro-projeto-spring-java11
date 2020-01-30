package com.gianprog.primeirospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gianprog.primeirospring.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}
