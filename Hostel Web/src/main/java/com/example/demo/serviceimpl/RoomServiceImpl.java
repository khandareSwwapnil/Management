package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Hostel;
import com.example.demo.entity.Rooms;
import com.example.demo.repository.HostelRepository;
import com.example.demo.repository.RoomsRepository;
import com.example.demo.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomsRepository roomsRepository;

    @Autowired
    private HostelRepository hostelRepository;

    @Override
    public Rooms createRoom(Long hostelId, Rooms room) {
        Hostel hostel = hostelRepository.findById(hostelId)
                .orElseThrow(() ->
                        new RuntimeException("Hostel not found with id: " + hostelId));

        room.setHostel(hostel);
        return roomsRepository.save(room);
    }

    @Override
    public Rooms getRoomById(Long id) {
        return roomsRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Room not found with id: " + id));
    }

    @Override
    public List<Rooms> getAllRooms() {
        return roomsRepository.findAll();
    }

    @Override
    public List<Rooms> getRoomsByHostel(Long hostelId) {
        return roomsRepository.findByHostel_Id(hostelId);
    }

    @Override
    public Rooms updateRoom(Long id, Rooms roomData) {

        Rooms room = roomsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + id));

    
        

        if (roomData.getStatus() != null) {
            room.setStatus(roomData.getStatus());
        }

        if (roomData.getCapacity() != null) {
            room.setCapacity(roomData.getCapacity());
        }

        return roomsRepository.save(room);
    }


    @Override
    public void deleteRoom(Long id) {
        Rooms room = roomsRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Room not found with id: " + id));

        roomsRepository.delete(room);
    }

}
