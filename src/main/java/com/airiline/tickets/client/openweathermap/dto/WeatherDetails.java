package com.airiline.tickets.client.openweathermap.dto;

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
