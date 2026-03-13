package com.example.demo.serviceimpl;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DashboardDto;
import com.example.demo.repository.OrganizationRepository;
import com.example.demo.repository.RoomsRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RoomsRepository roomsRepository;

    // ✅ NEW: For dashboard alerts (Organization module)
    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public DashboardDto getDashboardDto() {

        DashboardDto dashboardDto = new DashboardDto();

        // ✅ Old Logic (your current dashboard counts)
        long totalStudents = studentRepository.count();
        long totalRooms = roomsRepository.count();

        // ⚠️ Note: Here you need occupied room query
        // example: roomsRepository.countOccupiedRooms();
        // for now I am keeping it 0 to avoid wrong result
        long occupiedRooms = 0;

        long availableRooms = totalRooms - occupiedRooms;

        dashboardDto.setTotalStudents(totalStudents);
        dashboardDto.setTotalRooms(totalRooms);
        dashboardDto.setOccupaiedRooms(occupiedRooms);
        dashboardDto.setAvailableRooms(availableRooms);

        // ==========================================================
        // ✅ NEW LOGIC: Alerts Section for Admin Dashboard
        // ==========================================================

        // ✅ 1) Inactive organizations count
        // (status must exist in Organization table: ACTIVE / INACTIVE)
        long inactiveOrganizations = organizationRepository.countByStatus("INACTIVE");

        // ✅ 2) Today new organizations count
        LocalDateTime start = LocalDate.now().atStartOfDay();
        LocalDateTime end = start.plusDays(1);

        long todayNewOrganizations = organizationRepository.countByCreatedAtBetween(start, end);

        // ✅ 3) pending payments (if you don't have payment module now keep 0)
        long pendingPayments = 0;

        dashboardDto.setInactive30Days(inactiveOrganizations);
        dashboardDto.setTodayNewOrganizations(todayNewOrganizations);
        dashboardDto.setPendingPayments(pendingPayments);

        return dashboardDto;
    }
}

