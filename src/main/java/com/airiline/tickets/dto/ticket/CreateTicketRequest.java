package com.airiline.tickets.dto.ticket;

import com.airiline.tickets.domain.common.enums.TravelClass;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateTicketRequest {
    private BigDecimal price;
    private String seatNumber;
    private TravelClass travelClass;

    private Long flighId;
}
