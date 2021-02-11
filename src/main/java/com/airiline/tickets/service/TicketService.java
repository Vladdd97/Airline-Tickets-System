package com.airiline.tickets.service;

import com.airiline.tickets.dto.CreateTicketRequest;
import com.airiline.tickets.dto.CreateTicketResponse;
import com.airiline.tickets.dto.GetTicketByIdResponse;
import com.airiline.tickets.dto.UpdateTicketRequest;
import com.airiline.tickets.dto.UpdateTicketResponse;

public interface TicketService {
    CreateTicketResponse save(CreateTicketRequest ticketRequest);

    GetTicketByIdResponse getById(final Long id);

    UpdateTicketResponse update(UpdateTicketRequest ticketRequest);
}
