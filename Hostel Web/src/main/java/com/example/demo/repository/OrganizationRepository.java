package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Hostel;
import com.example.demo.entity.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

	long countByStatus(String status);

	long countByCreatedAtBetween(LocalDateTime start, LocalDateTime end);
	

}

