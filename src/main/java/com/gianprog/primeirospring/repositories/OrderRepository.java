package com.gianprog.primeirospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gianprog.primeirospring.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
