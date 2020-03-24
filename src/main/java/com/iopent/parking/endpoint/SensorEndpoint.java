package com.iopent.parking.endpoint;

public interface SensorEndpoint {
    void free(Long parkingId, Long sensorId);

    void occupy(Long parkingId, Long sensorId);
}
