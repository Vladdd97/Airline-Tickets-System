package com.airiline.tickets.service.impl;

import com.airiline.tickets.domain.Airport;
import com.airiline.tickets.dto.PageResponse;
import com.airiline.tickets.dto.airport.AirportResponse;
import com.airiline.tickets.dto.airport.CreateAirportRequest;
import com.airiline.tickets.dto.airport.CreateAirportResponse;
import com.airiline.tickets.dto.airport.UpdateAirportRequest;
import com.airiline.tickets.exception.EntityNotFoundException;
import com.airiline.tickets.mapper.AirportMapper;
import com.airiline.tickets.repository.AirportRepository;
import com.airiline.tickets.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AirportServiceImpl implements AirportService {
    private final AirportRepository airportRepository;

    @Override
    public CreateAirportResponse save(CreateAirportRequest airportRequest) {
        var airport = AirportMapper.INSTANCE.createAirportRequestToAirport(airportRequest);
        return AirportMapper.INSTANCE.airportToCreateAirportResponse(airportRepository.save(airport));
    }

    @Override
    public AirportResponse getById(Long airportId) {
        return AirportMapper.INSTANCE.airportToAirportResponse(findById(airportId));
    }

    @Override
    public void deleteById(Long airportId) {
        airportRepository.delete(findById(airportId));
    }

    @Override
    public AirportResponse update(Long airportId, UpdateAirportRequest airportRequest) {
        var airport = findById(airportId);
        AirportMapper.INSTANCE.updateAirportFromUpdateAirportRequest(airportRequest, airport);

        return AirportMapper.INSTANCE.airportToAirportResponse(airportRepository.save(airport));
    }

    @Override
    public Airport findById(Long airportId) {
        return airportRepository.findById(airportId)
                .orElseThrow(() -> new EntityNotFoundException("Airport not found by id: " + airportId));
    }

    @Override
    public PageResponse<AirportResponse> getAll(Pageable pageable) {
        var pageResponse = airportRepository.findAll(pageable);
        var airports = pageResponse.getContent().stream()
                .map(AirportMapper.INSTANCE::airportToAirportResponse)
                .collect(Collectors.toList());

        return PageResponse.createPageResponse(pageResponse, airports);
    }
}
