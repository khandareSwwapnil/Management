package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Rooms;

public interface RoomService {

    Rooms createRoom(Long hostelId, Rooms room);

    Rooms getRoomById(Long id);

    List<Rooms> getAllRooms();

    List<Rooms> getRoomsByHostel(Long hostelId);

    Rooms updateRoom(Long id, Rooms roomData);

    void deleteRoom(Long id);
}
