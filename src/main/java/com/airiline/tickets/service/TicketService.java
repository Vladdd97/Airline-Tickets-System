package com.airiline.tickets.service;

import com.airiline.tickets.dto.ticket.*;

import java.util.List;

public interface TicketService {
    CreateTicketResponse save(CreateTicketRequest ticketRequest);

    TicketResponse getById(Long id);

    TicketResponse update(UpdateTicketRequest ticketRequest, Long id);

    void deleteById(Long id);

    List<TicketResponse> searchByCriteria(SearchTicketRequest searchTicketRequest);
}
