package com.example.demo.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Invoice;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.InvoiceRepository;
import com.example.demo.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private BookingRepository bookingRepository;

	public InvoiceServiceImpl(InvoiceRepository invoiceRepository, BookingRepository bookingRepository) {
		this.invoiceRepository = invoiceRepository;
		this.bookingRepository = bookingRepository;
	}

	@Override
	public Invoice generateInvoice(Long bookingId, Invoice invoiceData) {

		Booking booking = bookingRepository.findById(bookingId)
				.orElseThrow(() -> new RuntimeException("Booking not found"));

		invoiceData.setBooking(booking);
		invoiceData.setInvoiceNo("INV-" + UUID.randomUUID().toString().substring(0, 8));

		Double total = invoiceData.getRentAmount()
				+ (invoiceData.getMessAmount() != null ? invoiceData.getMessAmount() : 0)
				+ (invoiceData.getAdditionalAmount() != null ? invoiceData.getAdditionalAmount() : 0);

		invoiceData.setTotalAmount(total);
		invoiceData.setGeneratedDate(LocalDate.now());

		return invoiceRepository.save(invoiceData);
	}

	@Override
	public List<Invoice> generateMonthlyInvoices(Integer month, Integer year) {

		List<Booking> activeBookings = bookingRepository.findByStatus("Active");

		return activeBookings.stream().map(booking -> {
			Invoice invoice = new Invoice();
			invoice.setBooking(booking);
			invoice.setMonth(month);
			invoice.setYear(year);

			invoice.setRentAmount(booking.getMonthlyRent());
			invoice.setMessAmount(0.0);
			invoice.setAdditionalAmount(0.0);

			invoice.setInvoiceNo("INV-" + UUID.randomUUID().toString().substring(0, 8));
			invoice.setGeneratedDate(LocalDate.now());
			invoice.setStatus("UNPAID");

			invoice.setTotalAmount(booking.getMonthlyRent());

			return invoiceRepository.save(invoice);

		}).toList();
	}

	@Override
	public Invoice getInvoice(Long id) {
		return invoiceRepository.findById(id).orElseThrow(() -> new RuntimeException("Invoice not found"));
	}

	@Override
	public List<Invoice> getAllInvoices() {
		return invoiceRepository.findAll();
	}

	@Override
	public List<Invoice> getInvoicesByBooking(Long bookingId) {

		Booking booking = bookingRepository.findById(bookingId)
				.orElseThrow(() -> new RuntimeException("Booking not found"));

		return invoiceRepository.findByBooking(booking);
	}

	@Override
	public Invoice markAsPaid(Long invoiceId) {

		Invoice invoice = invoiceRepository.findById(invoiceId)
				.orElseThrow(() -> new RuntimeException("Invoice not found"));

		invoice.setStatus("PAID");
		invoice.setPaidDate(LocalDate.now());

		return invoiceRepository.save(invoice);
	}

	@Override
	public void deleteInvoice(Long id) {
		invoiceRepository.deleteById(id);
	}

}
