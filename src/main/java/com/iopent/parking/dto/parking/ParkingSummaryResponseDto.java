package com.iopent.parking.dto.parking;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ParkingSummaryResponseDto {
    private final Integer free;
    private final Integer occupied;
}
