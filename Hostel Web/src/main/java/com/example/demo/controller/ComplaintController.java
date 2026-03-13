package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ComplaintRequestDto;
import com.example.demo.dto.ComplaintStatusDto;
import com.example.demo.entity.Complaint;
import com.example.demo.serviceimpl.ComplaintServiceImpl;

@RestController
@RequestMapping("/api/complaint")
@CrossOrigin(origins = "http://localhost:3000")
public class ComplaintController {
	
	@Autowired
	private ComplaintServiceImpl complaintServiceImpl;
	
	
	
	@PostMapping("/student/{StudentId}")
	public ResponseEntity<Complaint> create(@PathVariable Long studentId, @RequestBody ComplaintRequestDto dto){
			
				Complaint complaint = new Complaint();
				complaint.setCategory(dto.getCategory());
				complaint.setDescription(dto.getDescription());
				
				
		
		return ResponseEntity.ok(complaintServiceImpl.createComplaint(studentId, complaint));		
	
	}
	
	@GetMapping("/student/{studentId}")
	public ResponseEntity<List<Complaint>> getByStudent(
			@PathVariable Long studentId) {
		
		return ResponseEntity.ok(complaintServiceImpl.getComplaintsByStudent(studentId));
	}
	
	@GetMapping("/admin")
	public ResponseEntity<List<Complaint>> getAll() {
		return ResponseEntity.ok(complaintServiceImpl.getAllComplaints());
	}
	
	@PatchMapping("/{id}/status")
	public ResponseEntity<Complaint> updateStatus(
			@PathVariable Long id, 
			@RequestBody ComplaintStatusDto dto) {
		
				return ResponseEntity.ok(complaintServiceImpl.updateStatus(id, dto.getStatus()));
		
	}	

}
