package com.example.demo.exceptionHandler;

import com.example.demo.contants.ErrorConstant;

public class UserExceptionHandler extends RuntimeException{
	
	public UserExceptionHandler() {
		super(ErrorConstant.USER_NOT_FOUND);
	}

}
