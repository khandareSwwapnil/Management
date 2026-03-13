package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Hostel;
import com.example.demo.entity.Organization;
import com.example.demo.repository.HostelRepository;
import com.example.demo.repository.OrganizationRepository;
import com.example.demo.service.HostelService;

@Service
public class HostelServiceImpl implements HostelService {

    @Autowired
    private HostelRepository hostelRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public Hostel createHostel(Long organizationId, Hostel hostel) {
        Organization org = organizationRepository.findById(organizationId)
                .orElseThrow(() -> new RuntimeException("Organization not found with id: " + organizationId));

        hostel.setOrganization(org);
        return hostelRepository.save(hostel);
    }

    @Override
    public List<Hostel> getHostelsByOrganization(Long organizationId) {
        return hostelRepository.findByOrganization_Id(organizationId);
    }

    @Override
    public List<Hostel> getAllHostels() {   
        return hostelRepository.findAll();
    }

    @Override
    public void deleteHostel(Long hostelId) {
        hostelRepository.deleteById(hostelId);
    }
}
