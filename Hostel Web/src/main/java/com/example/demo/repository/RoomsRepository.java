package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Rooms;

@Repository
public interface RoomsRepository extends JpaRepository<Rooms, Long> {

    List<Rooms> findByHostel_Id(Long hostelId);
}
