package com.gianprog.primeirospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gianprog.primeirospring.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
}
