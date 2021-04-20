package com.airiline.tickets.dto.flight;

import com.airiline.tickets.domain.common.enums.City;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirportInfo {
    private Long id;
    private String code;
    private String name;
    private City city;
}
