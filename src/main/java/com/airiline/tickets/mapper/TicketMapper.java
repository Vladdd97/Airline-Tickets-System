package com.airiline.tickets.mapper;

import com.airiline.tickets.domain.Ticket;
import com.airiline.tickets.dto.CreateTicketRequest;
import com.airiline.tickets.dto.CreateTicketResponse;
import com.airiline.tickets.dto.TicketResponse;
import com.airiline.tickets.dto.UpdateTicketRequest;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface TicketMapper {
    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);

    Ticket createTicketRequestToTicket(CreateTicketRequest createTicketRequest);

    CreateTicketResponse ticketToCreateTicketResponse(Ticket ticket);

    TicketResponse ticketToTicketResponse(Ticket ticket);

    void updateTicketFromUpdateTicketRequest(UpdateTicketRequest updateTicketRequest, @MappingTarget Ticket ticket);
}
