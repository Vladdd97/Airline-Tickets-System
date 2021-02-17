package com.airiline.tickets.service;

import com.airiline.tickets.dto.flight.CreateFlightRequest;
import com.airiline.tickets.dto.flight.CreateFlightResponse;
import com.airiline.tickets.dto.flight.FlightResponse;

public interface FlightService {
    CreateFlightResponse save(CreateFlightRequest flightRequest);

    FlightResponse getById(Long flightId);

    void deleteById(Long id);
}
