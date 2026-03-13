package com.example.demo.dto;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.entity.InvoiceBreakup;

public class InvoiceDto {
	
	private Long studentId;
	private Long organizationId;
	private LocalDate invoiceDate;
	private List<InvoiceBreakup>breakups;
	
	
	public InvoiceDto(Long studentId, Long organizationId, LocalDate invoiceDate, List<InvoiceBreakup> breakups) {
		
		this.studentId = studentId;
		this.organizationId = organizationId;
		this.invoiceDate = invoiceDate;
		this.breakups = breakups;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public Long getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}
	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(LocalDate invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public List<InvoiceBreakup> getBreakups() {
		return breakups;
	}
	public void setBreakups(List<InvoiceBreakup> breakups) {
		this.breakups = breakups;
	}
	
	

}
