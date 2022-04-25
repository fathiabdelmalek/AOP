package com.fathi.aop.exceptions;

public class EmptyAccountException extends AccountException {
	
	private static final long serialVersionUID = 13L;
	
	public EmptyAccountException(String message) {
		super(message);
	}
}
