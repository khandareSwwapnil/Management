package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Beds;
import com.example.demo.entity.Booking;
import com.example.demo.entity.Rooms;
import com.example.demo.entity.Student;
import com.example.demo.repository.BedsRepository;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.RoomsRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BedsRepository bedsRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RoomsRepository roomsRepository;

    @Override
    public Booking createBooking(Booking booking, Long studentId, Long bedId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Beds bed = bedsRepository.findById(bedId)
                .orElseThrow(() -> new RuntimeException("Bed not found"));

        if (bed.isOccupied()) {
            throw new RuntimeException("Bed already occupied!");
        }

        bed.setOccupied(true);
        bedsRepository.save(bed);

        Rooms room = bed.getRooms();

        room.setOccupiedBeds(room.getOccupiedBeds() + 1);

        if (room.getOccupiedBeds() >= room.getCapacity()) {
            room.setStatus("OCCUPIED");
        }

        roomsRepository.save(room);

        booking.setStudent(student);
        booking.setBed(bed);
        booking.setRooms(room);
        booking.setStatus("ACTIVE");

        return bookingRepository.save(booking);
    }

    @Override
    public Booking endBooking(Long id) {

        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        Beds bed = booking.getBed();
        Rooms room = booking.getRooms();

        bed.setOccupied(false);
        bedsRepository.save(bed);

        room.setOccupiedBeds(room.getOccupiedBeds() - 1);

        if (room.getOccupiedBeds() < room.getCapacity()) {
            room.setStatus("AVAILABLE");
        }

        roomsRepository.save(room);

        booking.setStatus("COMPLETED");

        return bookingRepository.save(booking);
    }

    @Override
    public void deleteBooking(Long id) {

        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        if ("ACTIVE".equals(booking.getStatus())) {
            endBooking(id);
        }

        bookingRepository.delete(booking);
    }

	@Override
	public Booking getBookingById(Long id) {
		return null;
	}

	@Override
	public List<Booking> getAllBookings() {
		return null;
	}

	@Override
	public List<Booking> getBookingsByStudent(Long studentId) {
		return null;
	}

	@Override
	public Booking updateBooking(Long id, Booking booking) {
		return null;
	}

}

