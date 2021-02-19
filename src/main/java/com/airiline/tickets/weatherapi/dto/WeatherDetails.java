package com.airiline.tickets.weatherapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherDetails {
    private long id;
    private String name;
    private Coordinate coord;
    private MainInfo main;

}
