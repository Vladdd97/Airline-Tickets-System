package com.airiline.tickets.service;

import com.airiline.tickets.domain.Ticket;
import com.airiline.tickets.dto.ticket.TicketResponse;

import java.util.UUID;

public interface TicketService {
    Ticket saveEntity(Ticket ticket);

    TicketResponse getByIdentifier(UUID id);
}
