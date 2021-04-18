package com.airiline.tickets.domain;


import com.airiline.tickets.domain.common.enums.TicketStatus;
import com.airiline.tickets.domain.common.enums.TravelClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tickets")
public class Ticket extends AbstractEntity {
    private BigDecimal price;
    private String seatNumber;

    @Enumerated(EnumType.STRING)
    private TravelClass travelClass;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    @OneToOne()
    @JoinColumn(name = "passenger_id", referencedColumnName = "id")
    private Passenger passenger;
}
