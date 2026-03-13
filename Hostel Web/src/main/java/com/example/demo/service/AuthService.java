package com.example.demo.service;



import com.example.demo.dto.LoginRequestDto;
import com.example.demo.dto.SignupRequestDto;
import com.example.demo.entity.User;

public interface AuthService {
	
	User signup(SignupRequestDto request);
	
	
	User login(LoginRequestDto request);
	

}
