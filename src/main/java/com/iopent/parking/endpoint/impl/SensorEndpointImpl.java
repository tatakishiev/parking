package com.iopent.parking.endpoint.impl;

import com.iopent.parking.endpoint.SensorEndpoint;
import com.iopent.parking.entity.Parking;
import com.iopent.parking.entity.Sensor;
import com.iopent.parking.exceptions.ParkingNotFoundException;
import com.iopent.parking.exceptions.SensorNotFoundException;
import com.iopent.parking.service.ParkingService;
import com.iopent.parking.service.SensorService;
import org.springframework.stereotype.Component;

@Component
public class SensorEndpointImpl implements SensorEndpoint {

    private final ParkingService parkingService;
    private final SensorService sensorService;

    public SensorEndpointImpl(ParkingService parkingService,
                              SensorService sensorService) {
        this.parkingService = parkingService;
        this.sensorService = sensorService;
    }

    @Override
    public void free(Long parkingId, Long sensorId) {
        Parking parking = parkingService.findById(parkingId).orElseThrow(() -> new ParkingNotFoundException(parkingId));
        Sensor sensor = sensorService.findByParkingAndId(parking, sensorId)
                .orElseThrow(() -> new SensorNotFoundException(parkingId, sensorId));
        sensorService.free(sensor);
    }

    @Override
    public void occupy(Long parkingId, Long sensorId) {
        Parking parking = parkingService.findById(parkingId).orElseThrow(() -> new ParkingNotFoundException(parkingId));
        Sensor sensor = sensorService.findByParkingAndId(parking, sensorId)
                .orElseThrow(() -> new SensorNotFoundException(parkingId, sensorId));
        sensorService.occupy(sensor);
    }
}
