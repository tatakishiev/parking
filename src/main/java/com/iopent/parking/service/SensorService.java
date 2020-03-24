package com.iopent.parking.service;

import com.iopent.parking.entity.Parking;
import com.iopent.parking.entity.Sensor;

import java.util.Optional;

public interface SensorService {
    void occupy(Sensor sensor);

    void free(Sensor sensor);

    Optional<Sensor> findByParkingAndId(Parking parking, Long id);

    Integer getFreeSensors(Parking parking);

    Integer getOccupiedSensors(Parking parking);
}
