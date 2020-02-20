package com.abm.exceptions;

public class InvalidSiteIdException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InvalidSiteIdException() {
		super("Invalid Site ID Specified");
	}

	public InvalidSiteIdException(String errorMsg) {
		super(errorMsg);
	}

}
