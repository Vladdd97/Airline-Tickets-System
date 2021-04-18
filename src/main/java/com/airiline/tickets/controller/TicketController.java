package com.airiline.tickets.controller;

import com.airiline.tickets.dto.ticket.TicketResponse;
import com.airiline.tickets.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(TicketController.TICKET_URL)
public class TicketController {
    public static final String TICKET_URL = "/v1/ats/tickets";

    private final TicketService ticketService;

    @GetMapping("/{ticketIdentifier}")
    public ResponseEntity<TicketResponse> getByIdentifier(@PathVariable UUID ticketIdentifier) {
        return ResponseEntity.ok(ticketService.getByIdentifier(ticketIdentifier));
    }
}
