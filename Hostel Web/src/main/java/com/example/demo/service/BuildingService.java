package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Building;


public interface BuildingService {

	Building createBuilding(Building building, Long hostelId);

    Building getBuildingById(Long id);

    List<Building> getAllBuildings();

    List<Building> getBuildingsByHostel(Long hostelId);

    Building updateBuilding(Long id, Building building);

    void deleteBuilding(Long id);

}
