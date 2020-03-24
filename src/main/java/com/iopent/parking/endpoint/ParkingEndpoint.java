package com.iopent.parking.endpoint;

import com.iopent.parking.dto.parking.ParkingStatusResponseDto;
import com.iopent.parking.dto.parking.ParkingSummaryResponseDto;

public interface ParkingEndpoint {
    ParkingStatusResponseDto getStatus(Long id);

    ParkingSummaryResponseDto getSummary(Long id);
}
