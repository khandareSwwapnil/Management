package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Floors;


public interface FloorService {

	Floors createFloor(Floors floors, Long buildingId);

    Floors getFloorById(Long id);

    List<Floors> getFloorsByBuilding(Long buildingId);

    List<Floors> getAllFloors();

    Floors updateFloor(Long id, Floors floor);

    void deleteFloor(Long id);
	

}
