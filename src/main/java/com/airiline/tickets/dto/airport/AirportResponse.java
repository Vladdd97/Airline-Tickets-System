package com.airiline.tickets.dto.airport;

import com.airiline.tickets.domain.common.enums.City;
import lombok.Setter;
import lombok.Getter;

import java.util.Date;

@Setter
@Getter
public class AirportResponse {
    private Long id;
    private Date createDate;
    private Date updateDate;
    private String code;
    private String name;
    private City city;
}
