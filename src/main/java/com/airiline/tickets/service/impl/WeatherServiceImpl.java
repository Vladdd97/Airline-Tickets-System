package com.airiline.tickets.service.impl;

import com.airiline.tickets.service.WeatherService;
import com.airiline.tickets.client.openweathermap.OpenWeatherMapServiceClient;
import com.airiline.tickets.client.openweathermap.dto.SearchWeatherDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import static com.airiline.tickets.configuration.CachingConfiguration.WEATHER_CACHE;

@Service
@RequiredArgsConstructor
@ConditionalOnProperty(prefix = "open-weather-map", name = "use-mock", havingValue = "false")
public class WeatherServiceImpl implements WeatherService {

    private final OpenWeatherMapServiceClient weatherMapServiceClient;

    @Override
    @Cacheable(value = WEATHER_CACHE, key = "#cityName")
    public SearchWeatherDataResponse getWeatherByCityName(String cityName) {
        return weatherMapServiceClient.searchWeatherData(cityName);
    }
}
