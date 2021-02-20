package com.airiline.tickets.service.impl;

import com.airiline.tickets.service.WeatherService;
import com.airiline.tickets.weatherapi.OpenWeatherMapServiceClient;
import com.airiline.tickets.weatherapi.dto.SearchWeatherDataResponse;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@ConditionalOnProperty(prefix = "open-weather-map", name = "use-mock", havingValue = "false")
public class WeatherServiceImpl implements WeatherService {

    private OpenWeatherMapServiceClient weatherMapServiceClient;

    @Override
    public SearchWeatherDataResponse getWeatherByCityName(String cityName) {
        return weatherMapServiceClient.searchWeatherData(cityName);
    }
}
