package com.airiline.tickets.mapper;

import com.airiline.tickets.domain.Ticket;
import com.airiline.tickets.dto.ticket.TicketResponse;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface TicketMapper {
    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);

    TicketResponse ticketToTicketResponse(Ticket ticket);
}
