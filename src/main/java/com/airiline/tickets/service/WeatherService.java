package com.airiline.tickets.service;

import com.airiline.tickets.client.openweathermap.dto.SearchWeatherDataResponse;

public interface WeatherService {
    SearchWeatherDataResponse getWeatherByCityName(String cityName);
}
