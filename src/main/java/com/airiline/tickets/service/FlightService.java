package com.airiline.tickets.service;

import com.airiline.tickets.domain.Flight;
import com.airiline.tickets.dto.PageResponse;
import com.airiline.tickets.dto.flight.*;
import org.springframework.data.domain.Pageable;

public interface FlightService {
    CreateFlightResponse save(CreateFlightRequest flightRequest);

    FlightResponse getById(Long flightId);

    void deleteById(Long id);

    FlightResponse update(Long flightId, UpdateFlightRequest flightRequest);

    Flight findById(Long flightId);

    PageResponse<FlightResponse> searchByCriteria(SearchFlightRequest searchFlightRequest, Pageable pageable);
}
