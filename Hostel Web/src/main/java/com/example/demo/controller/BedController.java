package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Beds;
import com.example.demo.service.BedService;

@RestController
@RequestMapping("/api/beds")
@CrossOrigin(origins = "http://localhost:3000")
public class BedController {

    private final BedService bedService;

    public BedController(BedService bedService) {
        this.bedService = bedService;
    }

    @PostMapping("/rooms/{roomId}/beds")
    public ResponseEntity<Beds> createBed(
            @PathVariable Long roomId,
            @RequestBody Beds bed) {

        return ResponseEntity.ok(
                bedService.createBed(bed, roomId)
        );
    }

    @GetMapping("/rooms/{roomId}/beds")
    public ResponseEntity<List<Beds>> getBedsByRoom(
            @PathVariable Long roomId) {

        return ResponseEntity.ok(
                bedService.getBedsByRooms(roomId)
        );
    }

    @DeleteMapping("/beds/{bedId}")
    public ResponseEntity<Void> deleteBed(
            @PathVariable Long bedId) {

        bedService.deleteBed(bedId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/beds/{bedId}/status")
    public ResponseEntity<Beds> updateStatus(
            @PathVariable Long bedId,
            @RequestParam String status) {

        return ResponseEntity.ok(
                bedService.updateStatus(bedId, status)
        );
    }
}
