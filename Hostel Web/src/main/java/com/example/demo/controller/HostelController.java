package com.example.demo.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Hostel;
import com.example.demo.service.HostelService;

@RestController
@RequestMapping("/api/hostels")
@CrossOrigin(origins = "http://localhost:3000")
public class HostelController {

    @Autowired
    private HostelService hostelService;

    @PostMapping("/{organizationId}")
    public ResponseEntity<Hostel> createHostel(@PathVariable Long organizationId,
                                              @RequestBody Hostel hostel) {
        return ResponseEntity.ok(hostelService.createHostel(organizationId, hostel));
    }

    @GetMapping("/organization/{organizationId}")
    public ResponseEntity<List<Hostel>> getHostelsByOrganization(@PathVariable Long organizationId) {
        return ResponseEntity.ok(hostelService.getHostelsByOrganization(organizationId));
    }

    @GetMapping
    public ResponseEntity<List<Hostel>> getAllHostels() {
        return ResponseEntity.ok(hostelService.getAllHostels());
    }

    @DeleteMapping("/{hostelId}")
    public ResponseEntity<String> deleteHostel(@PathVariable Long hostelId) {
        hostelService.deleteHostel(hostelId);
        return ResponseEntity.ok("Hostel deleted successfully");
    }

    @PostMapping("/upload-image")
    public ResponseEntity<?> uploadHostelImage(@RequestParam("image") MultipartFile file) {
        try {
            if (file == null || file.isEmpty()) {
                return ResponseEntity.badRequest().body(Map.of("message", "Please upload valid image"));
            }

            String uploadDir = "uploads/hostels";
            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);

            Files.copy(file.getInputStream(), filePath);

            String imageUrl = "http://localhost:8080/" + uploadDir + "/" + fileName;

            return ResponseEntity.ok(Map.of(
                    "message", "Image uploaded successfully",
                    "imageUrl", imageUrl
            ));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(Map.of("message", "Upload failed"));
        }
    }
}
