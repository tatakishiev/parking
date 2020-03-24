package com.iopent.parking.controller;

import com.iopent.parking.endpoint.SensorEndpoint;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/parking/{parkingId:[\\d]+}")
public class SensorController {

    private final SensorEndpoint sensorEndpoint;

    public SensorController(SensorEndpoint sensorEndpoint) {
        this.sensorEndpoint = sensorEndpoint;
    }

    @PatchMapping("/{sensorId:[\\d]+}/free")
    public void free(@PathVariable Long parkingId, @PathVariable Long sensorId) {
        sensorEndpoint.free(parkingId, sensorId);
    }

    @PatchMapping("/{sensorId:[\\d]+}/occupy")
    public void occupy(@PathVariable Long parkingId, @PathVariable Long sensorId) {
        sensorEndpoint.occupy(parkingId, sensorId);
    }
}
