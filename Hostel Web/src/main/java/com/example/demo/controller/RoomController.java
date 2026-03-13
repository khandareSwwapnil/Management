package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Rooms;
import com.example.demo.service.RoomService;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "http://localhost:3000")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/hostel/{hostelId}")
    public ResponseEntity<Rooms> createRoom(
            @PathVariable Long hostelId,
            @RequestBody Rooms room) {
        return ResponseEntity.ok(roomService.createRoom(hostelId, room));
    }

    @GetMapping
    public ResponseEntity<List<Rooms>> getAllRooms() {
        return ResponseEntity.ok(roomService.getAllRooms());
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<Rooms> getRoomById(@PathVariable Long roomId) {
        return ResponseEntity.ok(roomService.getRoomById(roomId));
    }

    @GetMapping("/hostel/{hostelId}")
    public ResponseEntity<List<Rooms>> getRoomsByHostel(
            @PathVariable Long hostelId) {
        return ResponseEntity.ok(roomService.getRoomsByHostel(hostelId));
    }

    @PatchMapping("/{roomId}")
    public ResponseEntity<Rooms> updateRoom(
            @PathVariable Long id,
            @RequestBody Rooms room) {
        return ResponseEntity.ok(roomService.updateRoom(id, room));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }
}
