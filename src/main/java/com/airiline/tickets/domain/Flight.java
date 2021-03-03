package com.airiline.tickets.domain;

import lombok.*;

import javax.persistence.*;
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
    private String departureLocation;
    private String arrivalLocation;
    private Date departureDate;
    private Date arrivalDate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "flight_id")
    private List<Ticket> tickets = new ArrayList<>();
}
