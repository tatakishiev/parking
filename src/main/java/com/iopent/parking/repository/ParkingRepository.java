package com.iopent.parking.repository;

import com.iopent.parking.entity.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingRepository extends JpaRepository<Parking, Long> {
}
