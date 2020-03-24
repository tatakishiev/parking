package com.iopent.parking.service.impl;

import com.iopent.parking.entity.Parking;
import com.iopent.parking.repository.ParkingRepository;
import com.iopent.parking.service.ParkingService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParkingServiceImpl implements ParkingService {

    private final ParkingRepository parkingRepository;

    public ParkingServiceImpl(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    @Override
    public Optional<Parking> findById(Long id) {
        return parkingRepository.findById(id);
    }
}
