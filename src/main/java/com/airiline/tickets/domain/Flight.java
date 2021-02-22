package com.airiline.tickets.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

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
}
