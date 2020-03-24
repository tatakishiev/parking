package com.iopent.parking.dto.parking;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ParkingStatusResponseDto {
    private final Boolean hasFreeSpace;
}
