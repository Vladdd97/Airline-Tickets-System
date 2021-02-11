package com.airiline.tickets.controller;

import com.airiline.tickets.domain.Ticket;
import com.airiline.tickets.dto.CreateTicketRequest;
import com.airiline.tickets.dto.CreateTicketResponse;
import com.airiline.tickets.dto.GetTicketByIdResponse;
import com.airiline.tickets.dto.UpdateTicketRequest;
import com.airiline.tickets.dto.UpdateTicketResponse;
import com.airiline.tickets.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<GetTicketByIdResponse> getById(@PathVariable Long ticketId) {
        return ResponseEntity.status(HttpStatus.OK).body(ticketService.getById(ticketId));
    }

//    @PatchMapping("/{ticketId}")
//    public ResponseEntity<UpdateTicketResponse> update(@RequestBody UpdateTicketRequest ticket, @PathVariable Long ticketId) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(ticketService.save(ticket));
//    }
}
