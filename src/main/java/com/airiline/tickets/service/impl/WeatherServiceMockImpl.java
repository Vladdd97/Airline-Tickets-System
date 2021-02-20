package com.airiline.tickets.service.impl;

import com.airiline.tickets.service.WeatherService;
import com.airiline.tickets.weatherapi.dto.SearchWeatherDataResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
@Service
@AllArgsConstructor
@ConditionalOnProperty(prefix = "open-weather-map", name = "use-mock", havingValue = "true")
public class WeatherServiceMockImpl implements WeatherService {

    private final ObjectMapper objectMapper;

    @Override
    public SearchWeatherDataResponse getWeatherByCityName(String cityName) {
        log.info("Using WeatherServiceMockImpl in order to simulate a call to Open Weather Map API");
        SearchWeatherDataResponse result = null;
        try {
            result = objectMapper.readValue(readFile(), SearchWeatherDataResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private String readFile() throws IOException {
        return new String(Files.readAllBytes(Path.of("src/test/resources/expected-response/get-weather-details.json")));
    }

}
