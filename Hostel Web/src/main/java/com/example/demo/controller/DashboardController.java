package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DashboardDto;
import com.example.demo.service.DashboardService;


@RestController
@RequestMapping("/api/Dashboard")
@CrossOrigin(origins = "http://localhost:3000")
public class DashboardController {
	
	@Autowired
    private DashboardService dashboardService;

    @GetMapping
    public DashboardDto getDashboard() {
        return dashboardService.getDashboardDto();
    }

}
