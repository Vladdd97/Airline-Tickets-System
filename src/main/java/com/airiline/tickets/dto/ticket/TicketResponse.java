package com.airiline.tickets.dto.ticket;

import com.airiline.tickets.domain.common.enums.TicketStatus;
import com.airiline.tickets.domain.common.enums.TravelClass;
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
    private BigDecimal price;
    private String seatNumber;
    private TravelClass travelClass;
    private TicketStatus status;
}
