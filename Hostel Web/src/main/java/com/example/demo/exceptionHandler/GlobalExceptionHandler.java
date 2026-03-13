package com.example.demo.exceptionHandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.contants.Constant;
import com.example.demo.contants.ErrorConstant;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(UserExceptionHandler.class)
	public ResponseEntity<Map<String, Object>> handleUserExceptionHandler(UserExceptionHandler ex){
		
		Map<String, Object> res = new HashMap<>();
		res.put("error", ErrorConstant.USER_NOT_FOUND);
		res.put("message", Constant.USER_NOT_EXIST);
		return null;}
	
	
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Map<String, Object>> handleRuntimeException(RuntimeException ex) { 
		
		Map<String, Object> res = new HashMap<>();
		res.put("success", false);
		res.put("message", ex.getMessage());
		
		return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
		
	}
	
	

}
