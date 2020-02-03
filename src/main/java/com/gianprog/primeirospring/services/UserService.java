package com.gianprog.primeirospring.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gianprog.primeirospring.entities.User;
import com.gianprog.primeirospring.repositories.UserRepository;
import com.gianprog.primeirospring.services.exceptions.DatabaseException;
import com.gianprog.primeirospring.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);

		// Tenta dar o get, se não der vai lançar uma exceção.
		// Usei como parâmetro uma exp. lâmbda que possui o id como parâmetro
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public User update(Long id, User obj) {
		// O getOne() não busca do banco de dados ele só prepara o obj monitorado pra vc
		// mexer e depois efetuar uma operação com BD
		try {
			User entity = repository.getOne(id);
			UpdataData(entity, obj);

			return repository.save(entity);
		
		} catch (EntityNotFoundException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	private void UpdataData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
