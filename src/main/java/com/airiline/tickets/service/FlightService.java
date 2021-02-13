package com.airiline.tickets.service;

import com.airiline.tickets.dto.flight.CreateFlightRequest;
import com.airiline.tickets.dto.flight.CreateFlightResponse;

public interface FlightService {
    CreateFlightResponse save(CreateFlightRequest flightRequest);
}
