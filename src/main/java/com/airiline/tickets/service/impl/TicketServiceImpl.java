package com.airiline.tickets.service.impl;

import com.airiline.tickets.domain.Ticket;
import com.airiline.tickets.domain.common.enums.TicketStatus;
import com.airiline.tickets.dto.PageResponse;
import com.airiline.tickets.dto.ticket.*;
import com.airiline.tickets.exception.EntityNotFoundException;
import com.airiline.tickets.mapper.TicketMapper;
import com.airiline.tickets.repository.TicketRepository;
import com.airiline.tickets.service.FlightService;
import com.airiline.tickets.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final FlightService flightService;

    private final TicketRepository ticketRepository;

    @Override
    public CreateTicketResponse save(CreateTicketRequest ticketRequest) {
        var ticket = TicketMapper.INSTANCE.createTicketRequestToTicket(ticketRequest);
        ticket.setStatus(TicketStatus.AVAILABLE);

        var flight = flightService.findById(ticketRequest.getFlighId());
        flight.addTicket(ticket);

        return TicketMapper.INSTANCE.ticketToCreateTicketResponse(ticketRepository.save(ticket));
    }

    @Override
    public TicketResponse getById(Long id) {
        return TicketMapper.INSTANCE.ticketToTicketResponse(findById(id));
    }

    @Override
    public TicketResponse update(UpdateTicketRequest ticketRequest, Long id) {
        var ticket = findById(id);
        TicketMapper.INSTANCE.updateTicketFromUpdateTicketRequest(ticketRequest, ticket);

        return TicketMapper.INSTANCE.ticketToTicketResponse(ticketRepository.save(ticket));
    }

    @Override
    public void deleteById(Long id) {
        ticketRepository.delete(findById(id));
    }

    @Override
    public PageResponse<TicketResponse> searchByCriteria(SearchTicketRequest searchTicketRequest, int page, int size) {
        var pageResponse = ticketRepository.searchByCriteria(searchTicketRequest, page, size);
        var tickets = pageResponse.getContent().stream()
                .map(TicketMapper.INSTANCE::ticketToTicketResponse)
                .collect(Collectors.toList());
        return PageResponse.createPageResponse(pageResponse, tickets);
    }

    private Ticket findById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ticket not found by id: " + id));
    }
}
