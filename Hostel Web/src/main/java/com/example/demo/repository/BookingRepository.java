package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Student;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

	List<Booking> findByStudent(Student student);

	List<Booking> findByStatus(String status);

}
