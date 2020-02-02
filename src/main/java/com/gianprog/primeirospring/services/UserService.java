package com.gianprog.primeirospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gianprog.primeirospring.entities.User;
import com.gianprog.primeirospring.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj ) {
		//O getOne() não busca do banco de dados ele só prepara o obj monitorado pra vc mexer e depois efetuar uma operação com BD
		User entity = repository.getOne(id);
		UpdataData(entity, obj);
		
		return repository.save(entity);
	}

	private void UpdataData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
