package com.airiline.tickets.service.impl;

import com.airiline.tickets.dto.CreateTicketRequest;
import com.airiline.tickets.dto.CreateTicketResponse;
import com.airiline.tickets.mapper.TicketMapper;
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
        var ticket = TicketMapper.INSTANCE.createTicketRequestToTicket(ticketRequest);
        return TicketMapper.INSTANCE.ticketToCreateTicketResponse(ticketRepository.save(ticket));
    }
}
