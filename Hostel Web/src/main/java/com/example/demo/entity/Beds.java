package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "beds")
public class Beds {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long bedId;
	
	@Column(name = "bed_number",nullable = false)
	private String bedNumber;
	
	@Column(name = "bed_status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "room_id", nullable = false)
	private Rooms rooms;
	
	@ManyToOne
	@JoinColumn(name = "student_id", nullable = true)
	private Student student;

	public Long getBedId() {
		return bedId;
	}

	public void setBedId(Long bedId) {
		this.bedId = bedId;
	}

	public String getBedNumber() {
		return bedNumber;
	}

	public void setBedNumber(String bedNumber) {
		this.bedNumber = bedNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Rooms getRooms() {
		return rooms;
	}

	public void setRooms(Rooms rooms) {
		this.rooms = rooms;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public boolean isOccupied() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setOccupied(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
}


	