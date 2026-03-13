package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Beds;
import com.example.demo.entity.Rooms;
import com.example.demo.repository.BedsRepository;
import com.example.demo.repository.RoomsRepository;
import com.example.demo.service.BedService;

@Service
@Transactional
public class BedServiceImpl implements BedService {

    private final BedsRepository bedsRepository;
    private final RoomsRepository roomsRepository;

    public BedServiceImpl(BedsRepository bedsRepository,
                          RoomsRepository roomsRepository) {
        this.bedsRepository = bedsRepository;
        this.roomsRepository = roomsRepository;
    }

    @Override
    public Beds createBed(Beds bed, Long roomId) {

        Rooms room = roomsRepository.findById(roomId)
                .orElseThrow(() ->
                        new RuntimeException("Room not found"));

        bed.setRooms(room);
        
        if(bed.getBedNumber() == null) {
        	bed.setBedNumber("AUTO");
        }
        
        
        bed.setStatus("AVAILABLE");
        bed.setStudent(null);

        return bedsRepository.save(bed);
    }

    @Override
    public List<Beds> getBedsByRooms(Long roomId) {
        return bedsRepository.findByRooms_Id(roomId);
    }

    @Override
    public void deleteBed(Long bedId) {

        Beds bed = bedsRepository.findById(bedId)
                .orElseThrow(() ->
                        new RuntimeException("Bed not found"));

        if ("OCCUPIED".equals(bed.getStatus())) {
            throw new RuntimeException("Cannot delete occupied bed");
        }

        bedsRepository.delete(bed);
    }

    @Override
    public Beds updateStatus(Long bedId, String status) {

        Beds bed = bedsRepository.findById(bedId)
                .orElseThrow(() ->
                        new RuntimeException("Bed not found"));

        bed.setStatus(status);
        return bedsRepository.save(bed);
    }
}
