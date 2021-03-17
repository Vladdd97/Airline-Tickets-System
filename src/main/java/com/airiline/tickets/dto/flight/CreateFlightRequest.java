package com.airiline.tickets.dto.flight;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateFlightRequest {
    private String number;
    private Date departureDate;
    private Date arrivalDate;

    private Long departureAirportId;
    private Long arrivalAirportId;
}
