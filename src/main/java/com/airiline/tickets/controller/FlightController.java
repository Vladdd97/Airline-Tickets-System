package com.airiline.tickets.controller;

import com.airiline.tickets.dto.flight.CreateFlightRequest;
import com.airiline.tickets.dto.flight.CreateFlightResponse;
import com.airiline.tickets.dto.flight.FlightResponse;
import com.airiline.tickets.dto.flight.UpdateFlightRequest;
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
    public ResponseEntity<CreateFlightResponse> save(@RequestBody CreateFlightRequest flight) {
        return ResponseEntity.status(HttpStatus.CREATED).body(flightService.save(flight));
    }

    @GetMapping("/{flightId}")
    public ResponseEntity<FlightResponse> getById(@PathVariable Long flightId) {
        return ResponseEntity.ok(flightService.getById(flightId));
    }

    @DeleteMapping("/{flightId}")
    public ResponseEntity<Void> delete(@PathVariable Long flightId) {
        flightService.deleteById(flightId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{flightId}")
    public ResponseEntity<FlightResponse> update(@PathVariable Long flightId,
                                                 @RequestBody UpdateFlightRequest flightRequest) {
        return ResponseEntity.ok(flightService.update(flightId, flightRequest));
    }
}
