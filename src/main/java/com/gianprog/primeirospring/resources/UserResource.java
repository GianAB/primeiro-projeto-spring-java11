package com.gianprog.primeirospring.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gianprog.primeirospring.entities.User;

// Camadas de recursos
// Esta classe vai me disponibilizar um recurso web correspondente à intidede User


@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1l, "Maria", "maria@gmail.com" , "123123-333", "123");
		return ResponseEntity.ok().body(u);
	}
}
