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
@Table(name = "bookings")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name= "room_id")
	private Rooms rooms;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

	@ManyToOne
	@JoinColumn(name = "bed_id")
	private Beds bed;

	@Column(name = "stsrt_date")
	private LocalDate startDate;

	@Column(name = "end_date")
	private LocalDate endDate;

	@Column(name = "monthly_rent")
	private Double monthlyRent;

	@Column(name = "deposit_amount")
	private Double depositeAmount;

	private String status;

	public Booking() {
	}

	public Booking(Long id, Student student, Beds bed, LocalDate startDate, LocalDate endDate, Double monthlyRent,
			Double depositeAmount, String status) {

		this.id = id;
		this.student = student;
		this.bed = bed;
		this.startDate = startDate;
		this.endDate = endDate;
		this.monthlyRent = monthlyRent;
		this.depositeAmount = depositeAmount;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Beds getBed() {
		return bed;
	}

	public void setBed(Beds bed) {
		this.bed = bed;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Double getMonthlyRent() {
		return monthlyRent;
	}

	public void setMonthlyRent(Double monthlyRent) {
		this.monthlyRent = monthlyRent;
	}

	public Double getDepositeAmount() {
		return depositeAmount;
	}

	public void setDepositeAmount(Double depositeAmount) {
		this.depositeAmount = depositeAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
