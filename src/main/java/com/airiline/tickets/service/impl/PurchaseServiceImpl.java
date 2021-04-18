package com.airiline.tickets.service.impl;

import com.airiline.tickets.domain.Ticket;
import com.airiline.tickets.dto.purchase.PurchaseTicketRequest;
import com.airiline.tickets.dto.purchase.PurchaseTicketResponse;
import com.airiline.tickets.mapper.PurchaseMapper;
import com.airiline.tickets.service.FlightService;
import com.airiline.tickets.service.PassengerService;
import com.airiline.tickets.service.PurchaseService;
import com.airiline.tickets.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {
    private final PassengerService passengerService;
    private final FlightService flightService;
    private final TicketService ticketService;

    @Override
    public PurchaseTicketResponse purchaseTicket(PurchaseTicketRequest purchaseTicketRequest) {
        var flight = flightService.findById(purchaseTicketRequest.getFlightId());

        //TODO Check if there are available tickets for this flight

        var passenger = passengerService.findByPassportNumber(purchaseTicketRequest.getPassenger()
                .getPassportNumber()).orElseGet(() -> passengerService.saveEntity(purchaseTicketRequest.getPassenger()));

        var ticket = Ticket.builder()
                .identifier(UUID.randomUUID())
                .passenger(passenger)
                .build();

        flight.addTicket(ticket);
        ticketService.saveEntity(ticket);

        //TODO Decrement flight tickets count

        var purchaseTicketResponse = PurchaseMapper.INSTANCE.flightToPurchaseTicketResponse(flight);
        purchaseTicketResponse.setTicketIdentifier(ticket.getIdentifier());

        return purchaseTicketResponse;
    }
}
