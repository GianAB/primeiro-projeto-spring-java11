package com.gianprog.primeirospring.entities.enums;

public enum OrderStatus {
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	//Obs.: O construtor do tipo Enum é private
	private OrderStatus(int code) {
		this.code = code;
	}
	
	//Criar um método para acessar este código
	public int getCode() {
		return code;
	}
	
	//método static para converter um valor numérico para um valor Enum
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value: OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
	
}
