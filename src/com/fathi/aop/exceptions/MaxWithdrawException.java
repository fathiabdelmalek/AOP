package com.fathi.aop.exceptions;

public class MaxWithdrawException extends AccountException {
	
	private static final long serialVersionUID = 14L;
	
	public MaxWithdrawException(String message) {
		super(message);
	}
}
