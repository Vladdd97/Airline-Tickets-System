package com.airiline.tickets.service.impl;

import com.airiline.tickets.dto.CreateTicketRequest;
import com.airiline.tickets.dto.CreateTicketResponse;
import com.airiline.tickets.dto.GetTicketByIdResponse;
import com.airiline.tickets.dto.UpdateTicketRequest;
import com.airiline.tickets.dto.UpdateTicketResponse;
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
    public GetTicketByIdResponse getById(Long id) {
        var ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
        return TicketMapper.INSTANCE.ticketToGetTicketByIdResponse(ticket);
    }

    @Override
    public UpdateTicketResponse update(UpdateTicketRequest ticketRequest) {
        return null;
    }
}
