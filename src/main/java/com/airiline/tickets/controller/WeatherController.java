package com.airiline.tickets.controller;

import com.airiline.tickets.service.WeatherService;
import com.airiline.tickets.client.openweathermap.dto.SearchWeatherDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(WeatherController.WEATHER_URL)
public class WeatherController {
    public static final String WEATHER_URL = "/v1/ats/weather";

    private final WeatherService weatherService;

    @GetMapping("/{city}")
    public ResponseEntity<SearchWeatherDataResponse> getWeatherByCityName(@PathVariable String city) {
        return ResponseEntity.status(HttpStatus.OK).body(weatherService.getWeatherByCityName(city));
    }
}
