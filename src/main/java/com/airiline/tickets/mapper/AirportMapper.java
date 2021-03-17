package com.airiline.tickets.mapper;

import com.airiline.tickets.domain.Airport;
import com.airiline.tickets.dto.airport.AirportResponse;
import com.airiline.tickets.dto.airport.CreateAirportRequest;
import com.airiline.tickets.dto.airport.CreateAirportResponse;
import com.airiline.tickets.dto.airport.UpdateAirportRequest;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface AirportMapper {
    AirportMapper INSTANCE = Mappers.getMapper(AirportMapper.class);

    Airport createAirportRequestToAirport(CreateAirportRequest airportRequest);

    CreateAirportResponse airportToCreateAirportResponse(Airport airport);

    AirportResponse airportToAirportResponse(Airport airport);

    void updateAirportFromUpdateAirportRequest(UpdateAirportRequest airportRequest, @MappingTarget Airport airport);
}
