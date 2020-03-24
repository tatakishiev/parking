package com.iopent.parking.controller;

import com.iopent.parking.dto.parking.ParkingStatusResponseDto;
import com.iopent.parking.dto.parking.ParkingSummaryResponseDto;
import com.iopent.parking.endpoint.ParkingEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/parking/{id:[\\d]+}")
public class ParkingController {

    private final ParkingEndpoint parkingEndpoint;

    public ParkingController(ParkingEndpoint parkingEndpoint) {
        this.parkingEndpoint = parkingEndpoint;
    }

    @GetMapping("/status")
    public ParkingStatusResponseDto getStatus(@PathVariable Long id) {
        return parkingEndpoint.getStatus(id);
    }

    @GetMapping("/summary")
    public ParkingSummaryResponseDto getSummary(@PathVariable Long id) {
        return parkingEndpoint.getSummary(id);
    }
}
