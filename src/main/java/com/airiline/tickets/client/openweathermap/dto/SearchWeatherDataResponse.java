package com.airiline.tickets.client.openweathermap.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class SearchWeatherDataResponse {
    private String message;
    private int cod;
    private int count;
    private List<WeatherDetails> list;

}
