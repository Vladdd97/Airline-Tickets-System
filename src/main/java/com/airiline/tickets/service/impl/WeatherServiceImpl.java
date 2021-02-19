package com.airiline.tickets.service.impl;

import com.airiline.tickets.service.WeatherService;
import com.airiline.tickets.weatherapi.OpenWeatherMapServiceClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private OpenWeatherMapServiceClient weatherMapServiceClient;

    @Override
    public void getWeatherByCityName(String cityName) {
        weatherMapServiceClient.searchWeatherData(cityName);
    }
}
