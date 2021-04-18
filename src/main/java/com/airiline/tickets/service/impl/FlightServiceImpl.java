package com.airiline.tickets.service.impl;

import com.airiline.tickets.domain.Flight;
import com.airiline.tickets.dto.PageResponse;
import com.airiline.tickets.dto.flight.*;
import com.airiline.tickets.exception.EntityNotFoundException;
import com.airiline.tickets.mapper.FlightMapper;
import com.airiline.tickets.repository.FlightRepository;
import com.airiline.tickets.service.AirportService;
import com.airiline.tickets.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
    private final AirportService airportService;

    private final FlightRepository flightRepository;

    @Override
    public CreateFlightResponse save(CreateFlightRequest flightRequest) {
        var flight = FlightMapper.INSTANCE.createFlightRequestToFlight(flightRequest);

        setFlightAirports(flight, flightRequest.getDepartureAirportId(), flightRequest.getArrivalAirportId());

        return FlightMapper.INSTANCE.flightToCreateFlightResponse(flightRepository.save(flight));
    }

    @Override
    public FlightResponse getById(Long id) {
        return FlightMapper.INSTANCE.flightToFlightResponse(findById(id));
    }

    @Override
    public void deleteById(Long id) {
        flightRepository.delete(findById(id));
    }

    @Override
    public FlightResponse update(Long flightId, UpdateFlightRequest flightRequest) {
        var flight = findById(flightId);
        FlightMapper.INSTANCE.updateFlightFromUpdateFlightRequest(flightRequest, flight);

        setFlightAirports(flight, flightRequest.getDepartureAirportId(), flightRequest.getArrivalAirportId());

        return FlightMapper.INSTANCE.flightToFlightResponse(flightRepository.save(flight));
    }

    @Override
    public Flight findById(Long id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Flight not found by id: " + id));
    }

    @Override
    public PageResponse<FlightResponse> searchByCriteria(SearchFlightRequest searchFlightRequest,
                                                         Pageable pageable) {
        var pageResponse = flightRepository.searchByCriteria(searchFlightRequest,
                pageable.getPageNumber(), pageable.getPageSize());
        var flights = pageResponse.getContent().stream()
                .map(FlightMapper.INSTANCE::flightToFlightResponse)
                .collect(Collectors.toList());

        return PageResponse.createPageResponse(pageResponse, flights);
    }

    private void setFlightAirports(Flight flight, long departureAirportId, long arrivalAirportId) {
        var departureAirport = airportService.findById(departureAirportId);
        flight.setDepartureAirport(departureAirport);

        var arrivalAirport = airportService.findById(arrivalAirportId);
        flight.setArrivalAirport(arrivalAirport);
    }
}
