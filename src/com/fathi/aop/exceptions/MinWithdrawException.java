package com.fathi.aop.exceptions;

public class MinWithdrawException extends AccountException {
	
	private static final long serialVersionUID = 11L;
	
	public MinWithdrawException(String message) {
		super(message);
	}
}
