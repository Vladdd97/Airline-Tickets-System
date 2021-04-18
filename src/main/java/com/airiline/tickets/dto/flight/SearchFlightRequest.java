package com.airiline.tickets.dto.flight;

import com.airiline.tickets.domain.common.enums.City;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class SearchFlightRequest {
    private Long id;
    private BigDecimal ticketPrice;
    private City departureCity;
    private City arrivalCity;
    private Date departureDate;
    private Date arrivalDate;
}
