package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Hostel;

@Repository
public interface HostelRepository extends JpaRepository<Hostel, Long> {
    
	List<Hostel> findByOrganization_Id(Long id);


}
