package com.iopent.parking.service.impl;

import com.iopent.parking.entity.Parking;
import com.iopent.parking.entity.Sensor;
import com.iopent.parking.repository.SensorRepository;
import com.iopent.parking.service.SensorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SensorServiceImpl implements SensorService {

    private final SensorRepository sensorRepository;

    public SensorServiceImpl(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    @Transactional
    public void occupy(Sensor sensor) {
        sensor.setIsFree(false);
    }

    @Override
    @Transactional
    public void free(Sensor sensor) {
        sensor.setIsFree(true);
    }

    @Override
    @Transactional
    public Optional<Sensor> findByParkingAndId(Parking parking, Long id) {
        return sensorRepository.findByParkingAndId(parking, id);
    }

    @Override
    @Transactional
    public Integer getFreeSensors(Parking parking) {
        return sensorRepository.countAllByParkingAndIsFreeTrue(parking);
    }

    @Override
    @Transactional
    public Integer getOccupiedSensors(Parking parking) {
        return sensorRepository.countAllByParkingAndIsFreeFalse(parking);
    }
}
