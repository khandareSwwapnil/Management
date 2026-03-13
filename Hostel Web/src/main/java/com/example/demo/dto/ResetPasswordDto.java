package com.example.demo.dto;

import lombok.Data;

@Data
public class ResetPasswordDto {
	
	private String email;
	private String mobile;
	private String otp;
	private String newPassword;

}
