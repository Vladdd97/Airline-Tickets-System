package com.airiline.tickets.service.impl;

import com.airiline.tickets.service.WeatherService;
import com.airiline.tickets.client.openweathermap.dto.SearchWeatherDataResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.airiline.tickets.configuration.CachingConfiguration.WEATHER_CACHE;

@Slf4j
@Service
@RequiredArgsConstructor
@ConditionalOnProperty(prefix = "open-weather-map", name = "use-mock", havingValue = "true")
public class WeatherServiceMockImpl implements WeatherService {

    private final ObjectMapper objectMapper;

    @Override
    @Cacheable(value = WEATHER_CACHE, key = "#cityName")
    public SearchWeatherDataResponse getWeatherByCityName(String cityName) {
        log.info("Using WeatherServiceMockImpl in order to simulate a call to Open Weather Map API for [{}] city", cityName);
        SearchWeatherDataResponse result = null;
        try {
            result = objectMapper.readValue(readFile(), SearchWeatherDataResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private String readFile() throws IOException {
        return new String(Files.readAllBytes(
                Path.of("src/test/resources/open-weather-map-response/get-weather-by-city-name-success.json")));
    }

}
