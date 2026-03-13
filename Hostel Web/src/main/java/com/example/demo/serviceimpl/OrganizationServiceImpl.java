package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Organization;
import com.example.demo.repository.OrganizationRepository;
import com.example.demo.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {
	
	@Autowired
	private  OrganizationRepository organizationRepository ;
	
	 public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
	        this.organizationRepository = organizationRepository;
	 }

	@Override
	public Organization createOrganization(Organization organization) {
		return organizationRepository.save(organization);
	}

	@Override
	public Organization getOrganizationById(Long id) {
		return organizationRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Organition not found with id:"+ id));
	}

	@Override
	public List getAllOrganizations() {
		return organizationRepository.findAll();
	}

	@Override
	public Organization updateOrganization(Long id, Organization organization) {
		Organization existing = organizationRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Organition not found with id:"+ id));
		
		existing.setOrgName(organization.getOrgName());
		existing.setEmail(organization.getEmail());
		existing.setPhone(organization.getPhone());
		existing.setStatus(organization.getStatus());
		existing.setCreatedAt(organization.getCreatedAt());
		
		return organizationRepository.save(existing);
	}

	@Override
	public void deleteOrganization(Long id) {
		  Organization existing = organizationRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Organization not found with id: " + id));
	        organizationRepository.delete(existing);
		
	}

	@Override
	public Organization getById(Long orgId) {
	    return organizationRepository.findById(orgId)
	            .orElseThrow(() -> new RuntimeException("Organization not found: " + orgId));
	}

}
