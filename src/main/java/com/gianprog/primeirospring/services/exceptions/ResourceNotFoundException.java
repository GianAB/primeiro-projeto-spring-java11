package com.gianprog.primeirospring.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	//Recurso não encontrado
	public ResourceNotFoundException(Object id) {
		super("Resource not found. Id " + id);
	}
}
