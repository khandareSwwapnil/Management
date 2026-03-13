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

import com.example.demo.entity.Floors;
import com.example.demo.service.FloorService;

@RestController
@RequestMapping("/api/floors")
@CrossOrigin(origins = "http://localhost:3000")
public class FloorController {

	@Autowired
	private FloorService floorService;

	public FloorController(FloorService floorService) {
		this.floorService = floorService;
	}

	@PostMapping("/building/{buildingId}")
	public ResponseEntity<Floors> createFloor(@RequestBody Floors floor, @PathVariable Long buildingId) {

		return ResponseEntity.ok(floorService.createFloor(floor, buildingId));
	}

	@GetMapping
	public ResponseEntity<List<Floors>> getAllFloors() {
		return ResponseEntity.ok(floorService.getAllFloors());
	}

	@GetMapping("/{floorId}")
	public ResponseEntity<Floors> getFloorById(@PathVariable Long id) {
		return ResponseEntity.ok(floorService.getFloorById(id));
	}

	@GetMapping("/building/{buildingId}")
	public ResponseEntity<List<Floors>> getFloorsByBuilding(@PathVariable Long buildingId) {
		return ResponseEntity.ok(floorService.getFloorsByBuilding(buildingId));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Floors> updateFloor(@PathVariable Long id, @RequestBody Floors floor) {

		return ResponseEntity.ok(floorService.updateFloor(id, floor));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteFloor(@PathVariable Long id) {
		floorService.deleteFloor(id);
		return ResponseEntity.noContent().build();
	}
}
