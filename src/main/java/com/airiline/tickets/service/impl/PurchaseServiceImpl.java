package com.airiline.tickets.service.impl;

import com.airiline.tickets.domain.Flight;
import com.airiline.tickets.domain.Ticket;
import com.airiline.tickets.dto.event.EmailEvent;
import com.airiline.tickets.dto.purchase.PurchaseTicketRequest;
import com.airiline.tickets.dto.purchase.PurchaseTicketResponse;
import com.airiline.tickets.exception.NotEnoughAvailableTicketsException;
import com.airiline.tickets.mapper.PurchaseMapper;
import com.airiline.tickets.service.FlightService;
import com.airiline.tickets.service.PassengerService;
import com.airiline.tickets.service.PurchaseService;
import com.airiline.tickets.service.TicketService;
import com.airiline.tickets.service.event.EventPublisherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {
    private final PassengerService passengerService;
    private final FlightService flightService;
    private final TicketService ticketService;
    private final EventPublisherService eventPublisherService;

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public PurchaseTicketResponse purchaseTicket(PurchaseTicketRequest purchaseTicketRequest) throws JsonProcessingException {
        var flight = flightService.findById(purchaseTicketRequest.getFlightId());

        checkFlightAvailableTickets(flight);

        var passenger = passengerService.findByPassportNumber(purchaseTicketRequest.getPassenger()
                .getPassportNumber()).orElseGet(() -> passengerService.saveEntity(purchaseTicketRequest.getPassenger()));

        var ticket = Ticket.builder()
                .identifier(UUID.randomUUID())
                .passenger(passenger)
                .build();

        flight.addTicket(ticket);
        flight.setAvailableTickets((short) (flight.getAvailableTickets() - 1));
        ticketService.saveEntity(ticket);

        var purchaseTicketResponse = PurchaseMapper.INSTANCE.flightToPurchaseTicketResponse(flight);
        purchaseTicketResponse.setTicketIdentifier(ticket.getIdentifier());

        var emailEvent = EmailEvent.builder()
                .to(passenger.getEmail())
                .message("Thank you for using ATS. Your purchased ticket has identifier: " + ticket.getIdentifier() +
                        ". Use it in order to track your ticket.")
                .subject("ATS Ticket Purchase")
                .build();

        eventPublisherService.publishEmailEvent(emailEvent);

        return purchaseTicketResponse;
    }

    private void checkFlightAvailableTickets(Flight flight) {
        if (flight.getAvailableTickets() < 1) {
            throw new NotEnoughAvailableTicketsException("No available tickets for this flight");
        }
    }
}
