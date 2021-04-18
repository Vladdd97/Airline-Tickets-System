package com.airiline.tickets.mapper;

import com.airiline.tickets.domain.Flight;
import com.airiline.tickets.dto.purchase.PurchaseTicketResponse;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface PurchaseMapper {
    PurchaseMapper INSTANCE = Mappers.getMapper(PurchaseMapper.class);

    @Mapping(source = "departureAirport.code", target = "departureAirport")
    @Mapping(source = "arrivalAirport.code", target = "arrivalAirport")
    @Mapping(source = "number", target = "flightNumber")
    PurchaseTicketResponse flightToPurchaseTicketResponse(Flight flight);
}
