package com.airiline.tickets.service.impl;

import com.airiline.tickets.domain.Ticket;
import com.airiline.tickets.dto.CreateTicketRequest;
import com.airiline.tickets.dto.CreateTicketResponse;
import com.airiline.tickets.repository.TicketRepository;
import com.airiline.tickets.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Override
    public CreateTicketResponse save(CreateTicketRequest ticketRequest) {
        var ticket = ticketRepository.save(createTicket(ticketRequest));
        return createTicketResponse(ticket);
    }

    private Ticket createTicket(CreateTicketRequest ticketRequest) {
        return Ticket.builder()
                .departureLocation(ticketRequest.getDepartureLocation())
                .destinationLocation(ticketRequest.getDestinationLocation())
                .flightPrice(ticketRequest.getFlightPrice())
                .build();
    }

    private CreateTicketResponse createTicketResponse(Ticket ticket) {
        return CreateTicketResponse.builder()
                .id(ticket.getId())
                .departureLocation(ticket.getDepartureLocation())
                .destinationLocation(ticket.getDestinationLocation())
                .flightPrice(ticket.getFlightPrice())
                .build();
    }

}
