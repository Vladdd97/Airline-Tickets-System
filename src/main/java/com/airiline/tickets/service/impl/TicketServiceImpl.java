package com.airiline.tickets.service.impl;

import com.airiline.tickets.domain.Ticket;
import com.airiline.tickets.dto.CreateTicketRequest;
import com.airiline.tickets.dto.CreateTicketResponse;
import com.airiline.tickets.dto.TicketResponse;
import com.airiline.tickets.dto.UpdateTicketRequest;
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
        ticketRepository.deleteById(id);
    }

    private Ticket findById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }
}
