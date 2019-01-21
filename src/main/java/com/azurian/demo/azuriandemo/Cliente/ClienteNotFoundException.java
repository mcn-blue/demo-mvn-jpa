package com.azurian.demo.azuriandemo.Cliente;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ClienteNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	
	public ClienteNotFoundException(String id) {
		super(String.format(" not found : '%s'",id));
		this.id=id;
	
	}
	
	public String getId() {
		return this.id;
	}

}