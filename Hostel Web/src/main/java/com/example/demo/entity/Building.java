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
@Table(name = "buildings")
public class Building {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "no_of_floors")
	private Integer floors;
	private String name;
	private String warden;
	
	
	@ManyToOne
	@JoinColumn(name = "hostel_id")    
	private Hostel hostel;
	
	public Building() {}
	
	
	public Building(Long id, Integer floors, String name, String warden, Hostel hostel ) {
		this.id = id;
		this.floors = floors;
		this.name = name;
		
		this.hostel = hostel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getFloors() {
		return floors;
	}

	public void setFloors(Integer floors) {
		this.floors = floors;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Hostel getHostel() {
		return hostel;
	}

	public void setHostel(Hostel hostel) {
		this.hostel = hostel;
	}


	public String getWarden() {
		return warden;
	}


	public void setWarden(String warden) {
		this.warden = warden;
	}
	
	
	

}
