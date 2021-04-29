package com.airiline.tickets.dto.ticket;

import com.airiline.tickets.dto.flight.AirportInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class TicketResponse {
    private Long id;
    private Date createDate;
    private Date updateDate;
    private UUID identifier;

    private String passengerTitle;
    private String passengerFirstName;
    private String passengerLastName;

    private Date departureDate;
    private Date arrivalDate;

    private String flightNumber;

    private AirportInfo departureAirport;
    private AirportInfo arrivalAirport;
}
