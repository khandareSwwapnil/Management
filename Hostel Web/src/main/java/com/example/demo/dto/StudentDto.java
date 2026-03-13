package com.example.demo.dto;

import lombok.Data;

@Data
public class StudentDto {
	
	private Long studentId;
	private String studentName;
	private String moNo;
	private String stuAddress;
	private String email;
	private String parentContact;
	
	private String hostelName;
	private Integer roomNo;
	private Integer floor;
	
	
	
	public StudentDto(Long studentId, String studentName, String moNo, String stuAddress, String email,
			String parentContact, String hostelName, Integer roomNo, Integer floor) {
		
		this.studentId = studentId;
		this.studentName = studentName;
		this.moNo = moNo;
		this.stuAddress = stuAddress;
		this.email = email;
		this.parentContact = parentContact;
		this.hostelName = hostelName;
		this.roomNo = roomNo;
		this.floor = floor;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getParentContact() {
		return parentContact;
	}


	public void setParentContact(String parentContact) {
		this.parentContact = parentContact;
	}


	public String getHostelName() {
		return hostelName;
	}


	public void setHostelName(String hostelName) {
		this.hostelName = hostelName;
	}


	public Integer getRoomNo() {
		return roomNo;
	}


	public void setRoomNo(Integer roomNo) {
		this.roomNo = roomNo;
	}


	public Integer getFloor() {
		return floor;
	}


	public void setFloor(Integer floor) {
		this.floor = floor;
	}


	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getMoNo() {
		return moNo;
	}
	public void setMoNo(String moNo) {
		this.moNo = moNo;
	}
	public String getStuAddress() {
		return stuAddress;
	}
	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}
	
	

}
