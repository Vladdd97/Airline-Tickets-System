package com.airiline.tickets.service;

import com.airiline.tickets.domain.Airport;
import com.airiline.tickets.dto.PageResponse;
import com.airiline.tickets.dto.airport.AirportResponse;
import com.airiline.tickets.dto.airport.CreateAirportRequest;
import com.airiline.tickets.dto.airport.CreateAirportResponse;
import com.airiline.tickets.dto.airport.UpdateAirportRequest;
import org.springframework.data.domain.Pageable;

public interface AirportService {
    CreateAirportResponse save(CreateAirportRequest airportRequest);

    AirportResponse getById(Long airportId);

    void deleteById(Long airportId);

    AirportResponse update(Long airportId, UpdateAirportRequest airportRequest);

    Airport findById(Long airportId);

    PageResponse<AirportResponse> getAll(Pageable pageable);
}
