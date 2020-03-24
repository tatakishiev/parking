package com.iopent.parking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SensorNotFoundException extends EntityNotFoundException {
    public SensorNotFoundException(Long parkingId, Long sensorNumber) {
        super(String.format("Sensor not found. Parking id: %d, Sensor id: %d", parkingId, sensorNumber));
    }
}

