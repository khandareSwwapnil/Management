package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "organizations")
public class Organization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String orgName;
    private String email;
    private String phone;

	// ✅ NEW FIELDS (Feature-3,4,5)
	private String status; // ACTIVE / INACTIVE
	

	private LocalDateTime createdAt;
	
	@ManyToOne
	@JoinColumn(name="organization_id")
	private Organization organization;


	public Organization() {}

	@PrePersist
	public void onCreate() {
		this.createdAt = LocalDateTime.now();
		if (this.status == null) this.status = "ACTIVE";
		
	}

	public Long getOrgId() {
		return id;
	}

	public void setOrgId(Long orgId) {
		this.id = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	
}
