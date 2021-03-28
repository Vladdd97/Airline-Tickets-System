package com.airiline.tickets.service;

import com.airiline.tickets.dto.PageResponse;
import com.airiline.tickets.dto.ticket.*;

public interface TicketService {
    CreateTicketResponse save(CreateTicketRequest ticketRequest);

    TicketResponse getById(Long id);

    TicketResponse update(UpdateTicketRequest ticketRequest, Long id);

    void deleteById(Long id);

    PageResponse<TicketResponse> searchByCriteria(SearchTicketRequest searchTicketRequest, int page, int size);
}
