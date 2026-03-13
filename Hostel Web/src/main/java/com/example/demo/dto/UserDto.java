package com.example.demo.dto;

import java.time.LocalDate;

public class UserDto {
	private Long userId;
	private String name ;
	private String address;
	private LocalDate dob;
	private String email;
	private String mo_No;
	private String gender;
	private Boolean married;
	private String profession;
	
	
	public UserDto() {
        this.userId=userId;
		this.name = name;
		this.address = address;
		this.dob = dob;
		this.email = email;
		this.mo_No = mo_No;
		this.gender = gender;
		this.married = married;
		this.profession = profession;
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDbo(LocalDate dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMo_No() {
		return mo_No;
	}
	public void setMo_No(String mo_No) {
		this.mo_No = mo_No;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Boolean getMarried() {
		return married;
	}
	public void setMarried(Boolean married) {
		this.married = married;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	
	
	
	

}
