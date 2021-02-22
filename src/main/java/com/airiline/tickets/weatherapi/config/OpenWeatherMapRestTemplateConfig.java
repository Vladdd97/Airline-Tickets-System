package com.airiline.tickets.weatherapi.config;

import com.airiline.tickets.weatherapi.config.interceptor.RapidApiInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
public class OpenWeatherMapRestTemplateConfig {

    public static final String OPEN_WEATHER_MAP_REST_TEMPLATE_BEAN = "openWeatherMapRestTemplate";

    @Bean(OPEN_WEATHER_MAP_REST_TEMPLATE_BEAN)
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder, RapidApiInterceptor rapidApiInterceptor) {
        return restTemplateBuilder
                .interceptors(rapidApiInterceptor)
                .build();
    }

}
