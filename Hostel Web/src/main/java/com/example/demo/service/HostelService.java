package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Hostel;

public interface HostelService {
    Hostel createHostel(Long organizationId, Hostel hostel);
    List<Hostel> getHostelsByOrganization(Long organizationId);
    List<Hostel> getAllHostels();   
    void deleteHostel(Long hostelId);
}
