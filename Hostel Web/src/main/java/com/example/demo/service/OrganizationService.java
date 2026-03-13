package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.OrganizationDto;
import com.example.demo.entity.Organization;

public interface OrganizationService  {
	
	Organization createOrganization(Organization organization);

    Organization getOrganizationById(Long id);

    List<OrganizationDto> getAllOrganizations();

    Organization updateOrganization(Long id, Organization organization);
    
    Organization getById(Long orgId);
    
    void deleteOrganization(Long id);

	

}
