package com.airiline.tickets.service;

import com.airiline.tickets.domain.Flight;
import com.airiline.tickets.dto.flight.CreateFlightRequest;
import com.airiline.tickets.dto.flight.CreateFlightResponse;
import com.airiline.tickets.dto.flight.FlightResponse;
import com.airiline.tickets.dto.flight.UpdateFlightRequest;

public interface FlightService {
    CreateFlightResponse save(CreateFlightRequest flightRequest);

    FlightResponse getById(Long flightId);

    void deleteById(Long id);

    FlightResponse update(Long flightId, UpdateFlightRequest flightRequest);

    Flight findById(Long flightId);
}
