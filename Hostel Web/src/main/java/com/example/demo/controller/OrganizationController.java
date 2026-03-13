package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.example.demo.dto.OrganizationDto;
import com.example.demo.entity.Organization;
import com.example.demo.service.OrganizationService;

@RestController
@RequestMapping("/api/organizations")
@CrossOrigin(origins = "http://localhost:3000" )
public class OrganizationController {
	
	@Autowired
	private OrganizationService organizationService;
	
	 public OrganizationController(OrganizationService organizationService) {
	        this.organizationService = organizationService;
	 }
	
	@PostMapping
	public ResponseEntity<Organization>createOrganization(@RequestBody  Organization organization) {
        Organization created = organizationService.createOrganization(organization);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
	
	 @GetMapping
	    public ResponseEntity<List<OrganizationDto>> getAllOrganizations() {
	        List<OrganizationDto> organizations = organizationService.getAllOrganizations();
	        return ResponseEntity.ok(organizations);
	 }

	 @GetMapping("/{id}")
	    public ResponseEntity<Organization> getOrganizationById(@PathVariable Long id) {
	        Organization organization = organizationService.getOrganizationById(id);
	        return ResponseEntity.ok(organization);
	    }

	    
	  @PutMapping("/{id}")
	    public ResponseEntity<Organization> updateOrganization(
	            @PathVariable Long id,
	            @RequestBody Organization organization) {

	        Organization updated = organizationService.updateOrganization(id, organization);
	        return ResponseEntity.ok(updated);
	    }

	    
	  @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteOrganization(@PathVariable Long id) {
	        organizationService.deleteOrganization(id);
	        return ResponseEntity.noContent().build();
	    }
	  
	  	
}
