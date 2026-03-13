package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Building;
import com.example.demo.entity.Hostel;
import com.example.demo.repository.BuildingRepository;
import com.example.demo.repository.HostelRepository;
import com.example.demo.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {
	
	@Autowired
	private BuildingRepository buildingRepository;
	private HostelRepository hostelRepository;

   
	 public BuildingServiceImpl(BuildingRepository buildingRepository, HostelRepository hostelRepository) {
	        this.buildingRepository = buildingRepository;
	        this.hostelRepository = hostelRepository;
	    }

	    @Override
	    public Building createBuilding(Building building, Long hostelId) {

	        Hostel hostel = hostelRepository.findById(hostelId)
	                .orElseThrow(() -> new RuntimeException("Hostel not found"));

	        building.setHostel(hostel);

	        return buildingRepository.save(building);
	    }

	    @Override
	    public Building getBuildingById(Long id) {
	        return buildingRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Building not found"));
	    }

	    @Override
	    public List<Building> getAllBuildings() {
	        return buildingRepository.findAll();
	    }

	    @Override
	    public List<Building> getBuildingsByHostel(Long hostelId) {

	        Hostel hostel = hostelRepository.findById(hostelId)
	                .orElseThrow(() -> new RuntimeException("Hostel not found"));

	        return buildingRepository.findByHostel(hostel);
	    }

	    @Override
	    public Building updateBuilding(Long id, Building buildingData) {

	        Building building = buildingRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Building not found"));

	        building.setName(buildingData.getName());
	        building.setFloors(buildingData.getFloors());

	        return buildingRepository.save(building);
	    }

	    @Override
	    public void deleteBuilding(Long id) {
	        Building building = buildingRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Building not found"));
	        buildingRepository.delete(building);
	    }

}
