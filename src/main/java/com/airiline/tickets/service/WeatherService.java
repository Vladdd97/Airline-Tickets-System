package com.airiline.tickets.service;

import com.airiline.tickets.weatherapi.dto.SearchWeatherDataResponse;

public interface WeatherService {
    SearchWeatherDataResponse getWeatherByCityName(String cityName);
}
