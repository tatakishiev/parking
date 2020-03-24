package com.iopent.parking.service;

import com.iopent.parking.entity.Parking;

import java.util.Optional;

public interface ParkingService {
    Optional<Parking> findById(Long id);
}
