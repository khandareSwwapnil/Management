package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String rezorpayOrderId;
	private String rezorpayPaymentId;
	
	private Double amount;
	
	private String status;
	
	private LocalDateTime createdAt;
	
	@ManyToOne
	@JoinColumn(name="invoice_id")
	private Invoice invoice;
	
	
	
	
	

}
