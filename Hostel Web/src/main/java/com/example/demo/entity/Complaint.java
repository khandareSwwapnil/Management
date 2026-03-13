package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="complaints")
public class Complaint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	
	private String category;
	private String description;
	
	private String status;
	
	private LocalDateTime createdAt;
	private LocalDateTime resolvedAt;
	
	@ManyToOne
	@JoinColumn(name ="student_id")
	private Student student;
	

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.status = "OPEN";
    }
	
	

}
