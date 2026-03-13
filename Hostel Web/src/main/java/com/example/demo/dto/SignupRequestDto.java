package com.example.demo.dto;

import lombok.Data;

@Data
public class SignupRequestDto {
	
	private String name;
	private String email;
	private String mobile;
	private String role;
	private String password;
	private String confirmPassword;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getMbNo() {
		
		return null;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile() {
		this.mobile = mobile;
	}
	
	
	

}
