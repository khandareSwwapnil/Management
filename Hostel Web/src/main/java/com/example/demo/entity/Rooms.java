package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rooms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rooms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String roomNumber;

    private String roomType;

    private Integer capacity;
    
    @Column(name = "price")
    private double price;
    
    private String status;
    
    private Integer occupiedBeds;

    @ManyToOne
    @JoinColumn(name = "hostel_id")
    private Hostel hostel;
}
