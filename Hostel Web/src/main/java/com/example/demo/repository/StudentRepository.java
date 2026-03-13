package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Beds;
import com.example.demo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	
	List<Student> findByBed(Beds bed);


    List<Student> findByNameContainingIgnoreCase(String name);

    List<Student> findByStatus(String status);
}
