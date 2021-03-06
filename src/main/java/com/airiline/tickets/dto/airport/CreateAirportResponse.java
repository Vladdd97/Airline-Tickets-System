package com.airiline.tickets.dto.airport;

import com.airiline.tickets.domain.common.enums.City;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateAirportResponse {
    private Long id;
    private String code;
    private String name;
    private City city;
}
