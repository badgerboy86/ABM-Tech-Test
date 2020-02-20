package com.abm.exceptions;

public class InvalidCommandException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InvalidCommandException() {
		super("Invalid Command Specified");
	}

	public InvalidCommandException(String errorMsg) {
		super(errorMsg);
	}

}
