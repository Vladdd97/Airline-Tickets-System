package com.airiline.tickets.dto.ticket;

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
}
