package com.airiline.tickets.repository;

import com.airiline.tickets.domain.Ticket;
import com.airiline.tickets.dto.PageResponse;
import com.airiline.tickets.dto.ticket.SearchTicketRequest;

public interface SearchTicketRepository {
    PageResponse<Ticket> searchByCriteria(SearchTicketRequest searchTicketRequest, int page, int size);
}
