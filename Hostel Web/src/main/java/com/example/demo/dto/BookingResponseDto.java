package com.example.demo.dto;

public class BookingResponseDto {
	
	private Long bookingid;
	private String message;
	private String roomNo;
	private String bedNo;
	private String hostelname;
	private Double amount;
	public Long getBookingid() {
		return bookingid;
	}
	public void setBookingid(Long bookingid) {
		this.bookingid = bookingid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getBedNo() {
		return bedNo;
	}
	public void setBedNo(String bedNo) {
		this.bedNo = bedNo;
	}
	public String getHostelname() {
		return hostelname;
	}
	public void setHostelname(String hostelname) {
		this.hostelname = hostelname;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	

}
