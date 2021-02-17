package com.airiline.tickets.mapper;

import com.airiline.tickets.domain.Flight;
import com.airiline.tickets.dto.flight.CreateFlightRequest;
import com.airiline.tickets.dto.flight.CreateFlightResponse;
import com.airiline.tickets.dto.flight.FlightResponse;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface FlightMapper {
    FlightMapper INSTANCE = Mappers.getMapper(FlightMapper.class);

    Flight createFlightRequestToFlight(CreateFlightRequest createFlightRequest);

    CreateFlightResponse flightToCreateFlightResponse(Flight flight);

    FlightResponse flightToFlightResponse(Flight flight);
}