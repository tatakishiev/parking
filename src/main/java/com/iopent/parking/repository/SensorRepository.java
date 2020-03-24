package com.iopent.parking.repository;

import com.iopent.parking.entity.Parking;
import com.iopent.parking.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
    Optional<Sensor> findByParkingAndId(Parking parking, Long id);

    Integer countAllByParkingAndIsFreeTrue(Parking parking);

    Integer countAllByParkingAndIsFreeFalse(Parking parking);
}
