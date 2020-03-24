package com.iopent.parking.mapper.impl;

import com.iopent.parking.dto.parking.ParkingStatusResponseDto;
import com.iopent.parking.dto.parking.ParkingSummaryResponseDto;
import com.iopent.parking.mapper.ParkingMapper;
import org.springframework.stereotype.Component;

@Component
public class ParkingMapperImpl implements ParkingMapper {
    @Override
    public ParkingStatusResponseDto toParkingFreeSpaceResponseDto(Boolean hasFreeSpace) {
        return new ParkingStatusResponseDto(hasFreeSpace);
    }

    @Override
    public ParkingSummaryResponseDto toParkingSummaryResponseDto(Integer free, Integer occupied) {
        return new ParkingSummaryResponseDto(free, occupied);
    }
}
