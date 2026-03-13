package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String phone;
	private String address;
	private String email;
	private String parentContact;
	private String hostelName;
	private String roomNo;
	private String floor;
	
	
	@Column(name = "join_date")
	private LocalDate joinDate;
	
    private String status;
	
	
	@ManyToOne
	@JoinColumn(name ="bed_id")
	private Beds bed;
	
	public Student() {}
	
	public Student(Long id, String name, String phone, String address, String email, String parentContact,
			String hostelName, String roomNo, String floor, LocalDate joinDate, String status,
			Beds bed) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.parentContact = parentContact;
		this.hostelName = hostelName;
		this.roomNo = roomNo;
		this.floor = floor;
		
		this.joinDate = joinDate;
		this.status = status;
		this.bed = bed;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
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


	public String getRoomNo() {
		return roomNo;
	}


	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}


	public String getFloor() {
		return floor;
	}


	public void setFloor(String floor) {
		this.floor = floor;
	}


	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Beds getBeds() {
		return bed;
	}

	public void setBeds(Beds bed) {
		this.bed = bed;
	}
	
	
	
	
	

}
