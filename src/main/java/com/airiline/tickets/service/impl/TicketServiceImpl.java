package com.airiline.tickets.service.impl;

import com.airiline.tickets.domain.Ticket;
import com.airiline.tickets.dto.ticket.TicketResponse;
import com.airiline.tickets.exception.EntityNotFoundException;
import com.airiline.tickets.mapper.TicketMapper;
import com.airiline.tickets.repository.TicketRepository;
import com.airiline.tickets.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;

    @Override
    public Ticket saveEntity(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public TicketResponse getByIdentifier(UUID identifier) {
        return TicketMapper.INSTANCE.ticketToTicketResponse(ticketRepository.findByIdentifier(identifier)
                .orElseThrow(() -> new EntityNotFoundException("Ticket nout found by identifier: " + identifier)));
    }
}
