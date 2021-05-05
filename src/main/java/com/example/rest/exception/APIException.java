package com.example.rest.exception;

public class APIException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public APIException(String message) {
		super();
		this.message = message;
	}
	
	

}
