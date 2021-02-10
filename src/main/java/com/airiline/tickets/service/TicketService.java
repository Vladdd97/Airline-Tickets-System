package com.airiline.tickets.service;

import com.airiline.tickets.dto.CreateTicketRequest;
import com.airiline.tickets.dto.CreateTicketResponse;

public interface TicketService {
    CreateTicketResponse save(CreateTicketRequest ticket);
}
