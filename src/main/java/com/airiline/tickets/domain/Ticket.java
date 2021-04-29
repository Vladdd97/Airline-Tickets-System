package com.airiline.tickets.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tickets")
public class Ticket extends AbstractEntity {
    private UUID identifier;

    @OneToOne()
    @JoinColumn(name = "passenger_id", referencedColumnName = "id")
    private Passenger passenger;

    @ManyToOne
    private Flight flight;
}
