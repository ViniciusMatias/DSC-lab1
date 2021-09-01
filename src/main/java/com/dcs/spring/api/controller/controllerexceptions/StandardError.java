package com.dcs.spring.api.controller.controllerexceptions;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Instant intInstant;
	private Integer status;
	private String error;
	private String message;
	private String path;
	
	public StandardError(Instant intInstant, Integer status, String error, String message, String path) {
		super();
		this.intInstant = intInstant;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public StandardError() {
		super();
	}

	public Instant getIntInstant() {
		return intInstant;
	}

	public void setIntInstant(Instant intInstant) {
		this.intInstant = intInstant;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
	
	
}
