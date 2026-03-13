package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Hostel;
import com.example.demo.service.HostelService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/student/hostels")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class StudentHostelController {

    private final HostelService hostelService;

   
    @GetMapping
    public ResponseEntity<List<Hostel>> getAllHostelsForStudent() {
        return ResponseEntity.ok(hostelService.getAllHostels());
    }
}
