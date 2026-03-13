package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Building;
import com.example.demo.service.BuildingService;

@RestController
@RequestMapping("/api/building")
@CrossOrigin(origins = "http://localhost:3000")
public class BuildingController {
	
	@Autowired
	private BuildingService buildingService;
	
	public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    
    @PostMapping("/{hostelId}")
    public ResponseEntity<Building> createBuilding(
            @RequestBody Building building,
            @PathVariable Long hostelId) {

        return ResponseEntity.ok(buildingService.createBuilding(building, hostelId));
    }

    
    @GetMapping
    public ResponseEntity<List<Building>> getAll() {
        return ResponseEntity.ok(buildingService.getAllBuildings());
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Building> getById(@PathVariable Long id) {
        return ResponseEntity.ok(buildingService.getBuildingById(id));
    }

    
    @GetMapping("/hostel/{hostelId}")
    public ResponseEntity<List<Building>> getByHostel(@PathVariable Long hostelId) {
        return ResponseEntity.ok(buildingService.getBuildingsByHostel(hostelId));
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Building> updateBuilding(
            @PathVariable Long id,
            @RequestBody Building building) {

        return ResponseEntity.ok(buildingService.updateBuilding(id, building));
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuilding(@PathVariable Long id) {
        buildingService.deleteBuilding(id);
        
        return ResponseEntity.noContent().build();
    }

}
