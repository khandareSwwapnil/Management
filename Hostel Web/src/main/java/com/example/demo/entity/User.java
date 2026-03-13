package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Data
@Table(name = "users",uniqueConstraints = {
	    @UniqueConstraint(columnNames = "email"),
	    @UniqueConstraint(columnNames = "mobile")
	  })
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	@Column(nullable = false, unique = true)
	private String email;

	@Column( unique = true)
	private String mobile;

	private String password;

	private String role;
	
	private Boolean emailVerified = false;
	private Boolean mobileVerified = false;
	
	private String otp;
	
	private LocalDateTime otpExpiry;

}