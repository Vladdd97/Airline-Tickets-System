package com.airiline.tickets.controller;

import com.airiline.tickets.dto.flight.CreateFlightRequest;
import com.airiline.tickets.dto.flight.CreateFlightResponse;
import com.airiline.tickets.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/ats/flights")
public class FlightController {
    private final FlightService flightService;

    @PostMapping
    public ResponseEntity<CreateFlightResponse> save(@RequestBody CreateFlightRequest flight){
        return ResponseEntity.status(HttpStatus.CREATED).body(flightService.save(flight));
    }
}
