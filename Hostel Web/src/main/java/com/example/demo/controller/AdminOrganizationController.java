package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.AdminOrganizationDto;
import com.example.demo.dto.UpdateStatusDto;
import com.example.demo.dto.UpdateTagDto;
import com.example.demo.service.OrganizationAdminService;

@RestController
@RequestMapping("/api/admin/organizations")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminOrganizationController {

	@Autowired
	private OrganizationAdminService organizationAdminService;

	@GetMapping
	public ResponseEntity<List<AdminOrganizationDto>> getAllOrganizations() {
		return ResponseEntity.ok(organizationAdminService.getAllOrganizations());
	}

	@PutMapping("/{id}/status")
	public ResponseEntity<String> updateStatus(@PathVariable Long id, @RequestBody UpdateStatusDto dto) {
		organizationAdminService.updateStatus(id, dto.getStatus());
		return ResponseEntity.ok("Status updated successfully");
	}


	@GetMapping("/export/excel")
	public ResponseEntity<ByteArrayResource> exportExcel() {
		byte[] file = organizationAdminService.exportExcel();

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=organizations.xlsx")
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.body(new ByteArrayResource(file));
	}

	@GetMapping("/export/pdf")
	public ResponseEntity<ByteArrayResource> exportPdf() {
	    byte[] pdfBytes = organizationAdminService.exportPdf();

	    return ResponseEntity.ok()
	            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=organizations.pdf")
	            .contentType(MediaType.APPLICATION_PDF)
	            .contentLength(pdfBytes.length)
	            .body(new ByteArrayResource(pdfBytes));
	}

}
