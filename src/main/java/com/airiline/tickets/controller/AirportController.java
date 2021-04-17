package com.airiline.tickets.controller;

import com.airiline.tickets.dto.airport.AirportResponse;
import com.airiline.tickets.dto.airport.CreateAirportRequest;
import com.airiline.tickets.dto.airport.CreateAirportResponse;
import com.airiline.tickets.dto.airport.UpdateAirportRequest;
import com.airiline.tickets.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(AirportController.AIRPORT_URL)
public class AirportController {
    public static final String AIRPORT_URL = "/v1/ats/airports";

    private final AirportService airportService;

    @PostMapping
    public ResponseEntity<CreateAirportResponse> save(@RequestBody CreateAirportRequest airportRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(airportService.save(airportRequest));
    }

    @GetMapping("/{airportId}")
    public ResponseEntity<AirportResponse> getById(@PathVariable Long airportId){
        return ResponseEntity.ok(airportService.getById(airportId));
    }

    @DeleteMapping("/{airportId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long airportId){
        airportService.deleteById(airportId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{airportId}")
    public ResponseEntity<AirportResponse> update(@PathVariable Long airportId,
                                                  @RequestBody UpdateAirportRequest airportRequest){
        return ResponseEntity.ok(airportService.update(airportId, airportRequest));
    }
}
