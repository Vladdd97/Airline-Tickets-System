package com.airiline.tickets.service;

import com.airiline.tickets.dto.CreateTicketRequest;
import com.airiline.tickets.dto.CreateTicketResponse;
import com.airiline.tickets.dto.TicketResponse;
import com.airiline.tickets.dto.UpdateTicketRequest;

public interface TicketService {
    CreateTicketResponse save(CreateTicketRequest ticketRequest);

    TicketResponse getById(final Long id);

    TicketResponse update(UpdateTicketRequest ticketRequest, Long id);
}
