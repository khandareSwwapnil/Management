package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Invoice;

public interface InvoiceService {

	Invoice generateInvoice(Long bookingId, Invoice invoiceData);

	List<Invoice> generateMonthlyInvoices(Integer month, Integer year);

	Invoice getInvoice(Long id);

	List<Invoice> getAllInvoices();

	List<Invoice> getInvoicesByBooking(Long bookingId);

	Invoice markAsPaid(Long invoiceId);

	void deleteInvoice(Long id);

}
