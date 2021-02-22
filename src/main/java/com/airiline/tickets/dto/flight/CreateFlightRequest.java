package com.airiline.tickets.dto.flight;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateFlightRequest {
    private String number;
    private String departureLocation;
    private String arrivalLocation;
    private Date departureDate;
    private Date arrivalDate;
}
