package com.iopent.parking.mapper;

import com.iopent.parking.dto.parking.ParkingStatusResponseDto;
import com.iopent.parking.dto.parking.ParkingSummaryResponseDto;

public interface ParkingMapper {
    ParkingStatusResponseDto toParkingFreeSpaceResponseDto(Boolean hasFreeSpace);

    ParkingSummaryResponseDto toParkingSummaryResponseDto(Integer free, Integer occupied);
}
