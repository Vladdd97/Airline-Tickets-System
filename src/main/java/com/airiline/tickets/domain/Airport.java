package com.airiline.tickets.domain;

import com.airiline.tickets.domain.common.enums.City;
import lombok.*;

import javax.persistence.*;

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

    @Enumerated(EnumType.STRING)
    private City city;
}
