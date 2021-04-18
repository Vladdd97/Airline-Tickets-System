package com.airiline.tickets.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "flights")
public class Flight extends AbstractEntity {
    private String number;
    private Date departureDate;
    private Date arrivalDate;
    private short availableTickets;
    private BigDecimal ticketPrice;

    @OneToOne()
    @JoinColumn(name = "departure_airport_id", referencedColumnName = "id")
    private Airport departureAirport;

    @OneToOne()
    @JoinColumn(name = "arrival_airport_id", referencedColumnName = "id")
    private Airport arrivalAirport;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "flight_id")
    private List<Ticket> tickets = new ArrayList<>();

    public void addTicket(Ticket ticket){
        tickets.add(ticket);
    }
}
