package com.airiline.tickets.weatherapi.dto;

import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Getter
@Setter
public class SearchWeatherDataResponse {
    private String message;
    private int cod;
    private int count;
    private List<WeatherDetails> list;

}
