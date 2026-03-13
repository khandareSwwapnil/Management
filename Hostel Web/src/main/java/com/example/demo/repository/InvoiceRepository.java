package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

	List<Invoice> findByBooking(Booking booking);

	List<Invoice> findByStatus(String status);

	List<Invoice> findByMonthAndYear(Integer month, Integer year);

}
