package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Beds;

public interface BedService {
	
	Beds createBed(Beds bed, Long roomId);
	
	List<Beds> getBedsByRooms(Long roomId);
	
	void deleteBed(Long bedId);
	
	Beds updateStatus(Long bedId, String status);
}
