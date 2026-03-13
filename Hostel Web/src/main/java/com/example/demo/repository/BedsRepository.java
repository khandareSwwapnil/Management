package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Beds;
import com.example.demo.entity.Rooms;

@Repository
public interface BedsRepository extends JpaRepository<Beds, Long> {
	
	List<Beds> findByRooms_Id(Long roomId);
	
	List<Beds> findByRoomsAndStatus(Rooms rooms, String status);

	
}
