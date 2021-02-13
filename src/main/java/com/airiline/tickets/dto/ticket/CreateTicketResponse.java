package com.airiline.tickets.dto.ticket;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateTicketResponse {
    private Long id;
    private String departureLocation;
    private String destinationLocation;
    private BigDecimal flightPrice;
}
