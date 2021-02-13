package com.airiline.tickets.service.impl;

import com.airiline.tickets.dto.flight.CreateFlightRequest;
import com.airiline.tickets.dto.flight.CreateFlightResponse;
import com.airiline.tickets.mapper.FlightMapper;
import com.airiline.tickets.repository.FlightRepository;
import com.airiline.tickets.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;

    @Override
    public CreateFlightResponse save(CreateFlightRequest flightRequest){
        var flight = FlightMapper.INSTANCE.createFlightRequestToFlight(flightRequest);
        return FlightMapper.INSTANCE.flightToCreateFlightResponse(flightRepository.save(flight));
    }
}
