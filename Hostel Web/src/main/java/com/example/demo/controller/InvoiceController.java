package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Invoice;
import com.example.demo.service.InvoiceService;

@RestController
@RequestMapping("/api/invoices")
@CrossOrigin(origins = "http://localhost:3000")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;

	public InvoiceController(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}

	@PostMapping("/{bookingId}")
	public ResponseEntity<Invoice> generateInvoice(@RequestBody Invoice invoice, @PathVariable Long bookingId) {

		return ResponseEntity.ok(invoiceService.generateInvoice(bookingId, invoice));
	}

	@PostMapping("/{month}/{year}")
	public ResponseEntity<List<Invoice>> autoGenerateInvoices(@PathVariable Integer month, @PathVariable Integer year) {

		return ResponseEntity.ok(invoiceService.generateMonthlyInvoices(month, year));
	}

	@GetMapping
	public ResponseEntity<List<Invoice>> getAllInvoices() {
		return ResponseEntity.ok(invoiceService.getAllInvoices());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Invoice> getInvoiceById(@PathVariable Long id) {
		return ResponseEntity.ok(invoiceService.getInvoice(id));
	}

	@GetMapping("/{bookingId}")
	public ResponseEntity<List<Invoice>> getInvoicesByBooking(@PathVariable Long bookingId) {
		return ResponseEntity.ok(invoiceService.getInvoicesByBooking(bookingId));
	}

	@PutMapping("/{invoiceId}")
	public ResponseEntity<Invoice> markAsPaid(@PathVariable Long invoiceId) {
		return ResponseEntity.ok(invoiceService.markAsPaid(invoiceId));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		invoiceService.deleteInvoice(id);
		return ResponseEntity.noContent().build();
	}

}
