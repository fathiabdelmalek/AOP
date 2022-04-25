package com.fathi.aop.exceptions;

public class NegativeValueException extends AccountException {

	private static final long serialVersionUID = 12L;
	
	public NegativeValueException(String message) {
		super(message);
	}
}
