package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "floors")
public class Floors {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "floor_name")
	private Integer floorNo;
	
	
	@ManyToOne
	@JoinColumn(name = "building_id")
	private Building building;
	
	
	public Floors() {}
	public Floors(Long id, Integer floorNo, Building building) {
		super();
		this.id = id;
		this.floorNo = floorNo;
		this.building = building;
	}
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getFloors() {
		return floorNo;
	}
	public void setFloors(Integer floors) {
		this.floorNo = floors;
	}
	public Building getBuilding() {
		return building;
	}
	public void setBuilding(Building building) {
		this.building = building;
	}
	
	
	
	
	
	
	

}
