package com.airiline.tickets.controller;

import com.airiline.tickets.dto.CreateTicketRequest;
import com.airiline.tickets.dto.CreateTicketResponse;
import com.airiline.tickets.dto.TicketResponse;
import com.airiline.tickets.dto.UpdateTicketRequest;
import com.airiline.tickets.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/ats/tickets")
public class TicketController {

    private final TicketService ticketService;

    @PostMapping
    public ResponseEntity<CreateTicketResponse> save(@RequestBody CreateTicketRequest ticket) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketService.save(ticket));
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<TicketResponse> getById(@PathVariable Long ticketId) {
        return ResponseEntity.status(HttpStatus.OK).body(ticketService.getById(ticketId));
    }

    @PatchMapping("/{ticketId}")
    public ResponseEntity<TicketResponse> update(@RequestBody UpdateTicketRequest ticket, @PathVariable Long ticketId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketService.update(ticket, ticketId));
    }

    @DeleteMapping("/{ticketId}")
    public ResponseEntity<Void> delete(@PathVariable Long ticketId) {
        ticketService.deleteById(ticketId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
