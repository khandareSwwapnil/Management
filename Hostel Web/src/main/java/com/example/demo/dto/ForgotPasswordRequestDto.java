package com.example.demo.dto;

import lombok.Data;

@Data
public class ForgotPasswordRequestDto {
	
	private String email;
	private String mobile;
	private String type;

}
