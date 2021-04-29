package com.airiline.tickets.mapper;

import com.airiline.tickets.domain.Ticket;
import com.airiline.tickets.dto.ticket.TicketResponse;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface TicketMapper {
    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);

    @Mapping(source = "flight.departureAirport", target = "departureAirport")
    @Mapping(source = "flight.arrivalAirport", target = "arrivalAirport")
    @Mapping(source = "flight.number", target = "flightNumber")
    @Mapping(source = "flight.departureDate", target = "departureDate")
    @Mapping(source = "flight.arrivalDate", target = "arrivalDate")
    @Mapping(source = "passenger.firstName", target = "passengerFirstName")
    @Mapping(source = "passenger.lastName", target = "passengerLastName")
    @Mapping(source = "passenger.title", target = "passengerTitle")
    TicketResponse ticketToTicketResponse(Ticket ticket);
}
