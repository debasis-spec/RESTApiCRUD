package com.RestApiDev.first.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class resourceNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	public resourceNotFoundException(String message) {
	super(message);
	}
	public resourceNotFoundException(String message , Throwable throwable) {
		super(message , throwable);
		}
}
