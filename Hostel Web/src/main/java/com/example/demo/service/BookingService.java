package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Booking;

public interface BookingService  {
	
	Booking createBooking(Booking booking, Long studentId, Long bedId);

    Booking getBookingById(Long id);

    List<Booking> getAllBookings();

    List<Booking> getBookingsByStudent(Long studentId);

    Booking endBooking(Long id);

    Booking updateBooking(Long id, Booking booking);

    void deleteBooking(Long id);

}
