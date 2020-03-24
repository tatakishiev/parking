package com.iopent.parking.endpoint.impl;

import com.iopent.parking.dto.parking.ParkingStatusResponseDto;
import com.iopent.parking.dto.parking.ParkingSummaryResponseDto;
import com.iopent.parking.endpoint.ParkingEndpoint;
import com.iopent.parking.entity.Parking;
import com.iopent.parking.entity.Sensor;
import com.iopent.parking.exceptions.ParkingNotFoundException;
import com.iopent.parking.mapper.ParkingMapper;
import com.iopent.parking.service.ParkingService;
import com.iopent.parking.service.SensorService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ParkingEndpointImpl implements ParkingEndpoint {

    private final ParkingMapper parkingMapper;
    private final ParkingService parkingService;
    private final SensorService sensorService;

    public ParkingEndpointImpl(ParkingMapper parkingMapper,
                               ParkingService parkingService,
                               SensorService sensorService) {
        this.parkingMapper = parkingMapper;
        this.parkingService = parkingService;
        this.sensorService = sensorService;
    }

    @Override
    public ParkingStatusResponseDto getStatus(Long id) {
        Parking parking = parkingService.findById(id).orElseThrow(() -> new ParkingNotFoundException(id));
        Integer freeSensors = sensorService.getFreeSensors(parking);
        return parkingMapper.toParkingFreeSpaceResponseDto(freeSensors > 0);
    }

    @Override
    public ParkingSummaryResponseDto getSummary(Long id) {
        Parking parking = parkingService.findById(id).orElseThrow(() -> new ParkingNotFoundException(id));
        Integer freeSensors = sensorService.getFreeSensors(parking);
        Integer occupiedSensors = sensorService.getOccupiedSensors(parking);
        return parkingMapper.toParkingSummaryResponseDto(freeSensors, occupiedSensors);
    }
}
