package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Building;
import com.example.demo.entity.Floors;
import com.example.demo.repository.BuildingRepository;
import com.example.demo.repository.FloorRepository;
import com.example.demo.service.FloorService;

@Service
public class FloorServiceImpl implements FloorService {

	@Autowired
	private FloorRepository floorRepository;

	@Autowired
	private BuildingRepository buildingRepository;

	public FloorServiceImpl(FloorRepository floorRepository, BuildingRepository buildingRepository) {
		this.floorRepository = floorRepository;
		this.buildingRepository = buildingRepository;
	}

	@Override
	public Floors createFloor(Floors floor, Long buildingId) {

		Building building = buildingRepository.findById(buildingId)
				.orElseThrow(() -> new RuntimeException("Building not found"));

		floor.setBuilding(building);
		return floorRepository.save(floor);
	}

	@Override
	public Floors getFloorById(Long id) {
		return floorRepository.findById(id).orElseThrow(() -> new RuntimeException("Floor not found"));
	}

	@Override
	public List<Floors> getFloorsByBuilding(Long buildingId) {

		Building building = buildingRepository.findById(buildingId)
				.orElseThrow(() -> new RuntimeException("Building not found"));

		return floorRepository.findByBuilding(building);
	}

	@Override
	public List<Floors> getAllFloors() {
		return floorRepository.findAll();
	}

	@Override
	public Floors updateFloor(Long id, Floors floorData) {

		Floors floor = floorRepository.findById(id).orElseThrow(() -> new RuntimeException("Floor not found"));

		floor.setFloors(floorData.getFloors());

		return floorRepository.save(floor);
	}

	@Override
	public void deleteFloor(Long id) {
		Floors floor = floorRepository.findById(id).orElseThrow(() -> new RuntimeException("Floor not found"));
		floorRepository.delete(floor);
	}
}
