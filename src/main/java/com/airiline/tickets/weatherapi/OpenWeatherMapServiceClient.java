package com.airiline.tickets.weatherapi;

import com.airiline.tickets.weatherapi.config.OpenWeatherMapServiceConfig;
import com.airiline.tickets.weatherapi.dto.SearchWeatherDataResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static com.airiline.tickets.weatherapi.config.OpenWeatherMapRestTemplateConfig.OPEN_WEATHER_MAP_REST_TEMPLATE_BEAN;

@Slf4j
@Component
public class OpenWeatherMapServiceClient {

    private final OpenWeatherMapServiceConfig config;
    private final RestTemplate restTemplate;

    public OpenWeatherMapServiceClient
            (OpenWeatherMapServiceConfig config,
             @Qualifier(OPEN_WEATHER_MAP_REST_TEMPLATE_BEAN) RestTemplate weatherApiServiceRestTemplate) {
        this.config = config;
        this.restTemplate = weatherApiServiceRestTemplate;
    }


    public SearchWeatherDataResponse searchWeatherData(String cityName) {
        log.info(String.format("Search weather data by [%s] cityName", cityName));

        var response = restTemplate.getForObject(
                String.format(config.getSearchWeatherDataUrl(), cityName),
                SearchWeatherDataResponse.class);
        log.info(String.format("Weather data for [%s] city: %s", cityName, response));

        return response;
    }

}
