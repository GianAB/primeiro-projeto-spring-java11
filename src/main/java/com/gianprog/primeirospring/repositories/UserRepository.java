package com.gianprog.primeirospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gianprog.primeirospring.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
