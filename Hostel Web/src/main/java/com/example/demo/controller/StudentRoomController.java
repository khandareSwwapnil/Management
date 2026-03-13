package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Rooms;
import com.example.demo.repository.RoomsRepository;

@RestController
@RequestMapping("/api/student")
@CrossOrigin
public class StudentRoomController {
	
	@Autowired
	private  RoomsRepository roomsRepository;
	
	 @GetMapping("/rooms")
	    public ResponseEntity<List<Rooms>> getRoomsForStudent(
	            @RequestParam Long hostelId) {

	        List<Rooms> rooms = roomsRepository.findByHostel_Id(hostelId);
	        return ResponseEntity.ok(rooms);
	    }

}
