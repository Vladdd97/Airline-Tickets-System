package com.airiline.tickets.repository;

import com.airiline.tickets.domain.Ticket;
import com.airiline.tickets.dto.ticket.SearchTicketRequest;

import java.util.List;

public interface SearchTicketRepository {
    List<Ticket> searchByCriteria(SearchTicketRequest searchTicketRequest);
}
