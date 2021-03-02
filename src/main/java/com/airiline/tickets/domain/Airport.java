package com.airiline.tickets.domain;

import com.airiline.tickets.utility.enums.City;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "airports")
public class Airport extends AbstractEntity{
    private String code;
    private String name;
    private City city;
}
