package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AdminOrganizationDto;

public interface OrganizationAdminService {

	List<AdminOrganizationDto> getAllOrganizations();

	void updateStatus(Long id, String status);

	void updateTag(Long id, String tag);

	byte[] exportExcel();   // Feature-1
	byte[] exportPdf();     // Feature-1
}

