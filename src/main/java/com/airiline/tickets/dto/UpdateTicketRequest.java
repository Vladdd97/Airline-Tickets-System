package com.airiline.tickets.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UpdateTicketRequest {
    private String departureLocation;
    private String destinationLocation;
    private BigDecimal flightPrice;
}
