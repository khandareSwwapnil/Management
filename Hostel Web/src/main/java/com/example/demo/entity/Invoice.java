package com.example.demo.entity;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "invoice")
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String invoiceNo;
	private Integer month;
	private Integer year;
	private Double rentAmount;
	private Double messAmount;
	private Double additionalAmount;
	private Double totalAmount;
	
	private String status;
	
	private LocalDate generatedDate;
	private LocalDate paidDate;
	
	@ManyToOne
	@JoinColumn(name ="booking_id")
	private Booking booking;
	
	public Invoice() {}
	

	public Invoice(Long id, String invoiceNo, Integer month, Integer year, Double rentAmount, Double messAmount,
			Double additionalAmount, Double totalAmount, String status, LocalDate generatedDate, LocalDate paidDate,
			Booking booking) {
		
		this.id = id;
		this.invoiceNo = invoiceNo;
		this.month = month;
		this.year = year;
		this.rentAmount = rentAmount;
		this.messAmount = messAmount;
		this.additionalAmount = additionalAmount;
		this.totalAmount = totalAmount;
		this.status = status;
		this.generatedDate = generatedDate;
		this.paidDate = paidDate;
		this.booking = booking;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Double getRentAmount() {
		return rentAmount;
	}

	public void setRentAmount(Double rentAmount) {
		this.rentAmount = rentAmount;
	}

	public Double getMessAmount() {
		return messAmount;
	}

	public void setMessAmount(Double messAmount) {
		this.messAmount = messAmount;
	}

	public Double getAdditionalAmount() {
		return additionalAmount;
	}

	public void setAdditionalAmount(Double additionalAmount) {
		this.additionalAmount = additionalAmount;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getGeneratedDate() {
		return generatedDate;
	}

	public void setGeneratedDate(LocalDate generatedDate) {
		this.generatedDate = generatedDate;
	}

	public LocalDate getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(LocalDate paidDate) {
		this.paidDate = paidDate;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	
	
	
}
