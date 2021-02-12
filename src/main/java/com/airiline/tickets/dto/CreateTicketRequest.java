package com.airiline.tickets.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateTicketRequest {
    private String departureLocation;
    private String destinationLocation;
    private BigDecimal flightPrice;
}
