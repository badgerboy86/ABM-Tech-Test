package com.abm.model;

public class ResponseModel {

	/**
	 * POJO to store Status Code & Message
	 */
	
	private int  statusCode;
	private String  message;
	
	public ResponseModel() {}

	public ResponseModel(int statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setErrorCode(int statusCode) {
		this.statusCode = statusCode;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
