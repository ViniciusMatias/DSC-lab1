package com.dcs.spring.api.services.exception;

public class EntityNotFoundEx extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	
	public EntityNotFoundEx(String msg) {
		super(msg);
	}

}
