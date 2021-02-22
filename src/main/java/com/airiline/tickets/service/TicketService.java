package com.airiline.tickets.service;

import com.airiline.tickets.dto.ticket.CreateTicketRequest;
import com.airiline.tickets.dto.ticket.CreateTicketResponse;
import com.airiline.tickets.dto.ticket.TicketResponse;
import com.airiline.tickets.dto.ticket.UpdateTicketRequest;

public interface TicketService {
    CreateTicketResponse save(CreateTicketRequest ticketRequest);

    TicketResponse getById(final Long id);

    TicketResponse update(UpdateTicketRequest ticketRequest, Long id);

    void deleteById(Long id);
}
