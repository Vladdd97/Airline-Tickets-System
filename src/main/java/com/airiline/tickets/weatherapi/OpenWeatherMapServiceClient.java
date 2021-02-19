package com.airiline.tickets.weatherapi;

import com.airiline.tickets.weatherapi.config.OpenWeatherMapServiceConfig;
import com.airiline.tickets.weatherapi.dto.WeatherMapResponse;
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


    public void searchWeatherData(String cityName) {
        var response = restTemplate.getForObject(
                String.format(config.getSearchWeatherDataUrl(), cityName),
                WeatherMapResponse.class);

        System.out.println(response);
    }

}
