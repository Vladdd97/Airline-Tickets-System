package com.airiline.tickets.dto.flight;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class CreateFlightResponse {
    private Long id;
    private String number;
    private Date departureDate;
    private Date arrivalDate;
    private short availableTickets;
    private BigDecimal ticketPrice;

    private AirportInfo departureAirport;
    private AirportInfo arrivalAirport;
}
