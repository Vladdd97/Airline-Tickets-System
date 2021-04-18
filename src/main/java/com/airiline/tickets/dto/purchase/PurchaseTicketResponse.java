package com.airiline.tickets.dto.purchase;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
public class PurchaseTicketResponse {
    private String flightNumber;
    private Date departureDate;
    private Date arrivalDate;
    private String departureAirport;
    private String arrivalAirport;

    private UUID ticketIdentifier;
}
