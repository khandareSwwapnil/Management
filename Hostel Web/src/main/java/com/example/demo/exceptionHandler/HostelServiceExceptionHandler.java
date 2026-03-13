package com.example.demo.exceptionHandler;

import org.springframework.http.HttpStatus;

public class HostelServiceExceptionHandler extends RuntimeException {
	
	private HttpStatus httpStatus;
	private String errorMessage;
	
	
	public HostelServiceExceptionHandler(HttpStatus httpStatus, String errorMessage) {
		super();
		this.httpStatus = httpStatus;
		this.errorMessage = errorMessage;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	

}
