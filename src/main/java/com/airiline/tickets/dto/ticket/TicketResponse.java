package com.airiline.tickets.dto.ticket;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class TicketResponse {
    private Long id;
    private Date createDate;
    private Date updateDate;
    private String departureLocation;
    private String destinationLocation;
    private BigDecimal flightPrice;
}
