package com.iopent.parking.controller;

import com.iopent.parking.dto.parking.ParkingSummaryResponseDto;
import com.iopent.parking.endpoint.ParkingEndpoint;
import com.iopent.parking.exceptions.ParkingNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ParkingController.class)
public class ParkingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ParkingEndpoint parkingEndpoint;

    @Test
    public void getSummary_shouldReturnParkingSummary_whenThereIsExistingParking() throws Exception {
        ParkingSummaryResponseDto responseDto = new ParkingSummaryResponseDto(10, 10);

        when(parkingEndpoint.getSummary(1L)).thenReturn(responseDto);

        this.mockMvc.perform(get("/api/parking/1/summary"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.free").value(10))
                .andExpect(MockMvcResultMatchers.jsonPath("$.occupied").value(10));
    }

    @Test
    public void getSummary_shouldReturn404_whenThereIsNoParkingByGivenId() throws Exception {
        when(parkingEndpoint.getSummary(1L)).thenThrow(ParkingNotFoundException.class);

        this.mockMvc.perform(get("/api/parking/1/summary")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
