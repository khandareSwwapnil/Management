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
@Table(name ="hostels")
public class Hostel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String address;
	private String imagePath;
	
	@Column(name = "capacity")
	private Integer capacity;
	
	@Column(name = "contact_No")
	private String contact_No;
	
	
	@ManyToOne
	@JoinColumn(name = "organization_id")
	private Organization organization;
	
	public Hostel() {}
	
	

	public Hostel(Long id, String name, String address, Integer capacity, 
			String contact_No, Organization organization, String email, String imagePath
			) {
	
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.imagePath = imagePath;
		this.capacity = capacity;
		this.contact_No = contact_No;
		this.organization = organization;
		
		
	}
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
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
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public String getContact_No() {
		return contact_No;
	}
	public void setContact_No(String contact_No) {
		this.contact_No = contact_No;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImagrPath() {
		return imagePath;
	}

	public void setImagrPath(String imagrPath) {
		this.imagePath = imagrPath;
	}
	
	
	
	

}
