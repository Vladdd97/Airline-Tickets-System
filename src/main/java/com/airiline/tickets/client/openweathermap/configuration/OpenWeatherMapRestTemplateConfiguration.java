package com.airiline.tickets.client.openweathermap.configuration;

import com.airiline.tickets.client.openweathermap.configuration.interceptor.RapidApiInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
public class OpenWeatherMapRestTemplateConfiguration {

    public static final String OPEN_WEATHER_MAP_REST_TEMPLATE_BEAN = "openWeatherMapRestTemplate";

    @Bean(OPEN_WEATHER_MAP_REST_TEMPLATE_BEAN)
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder, RapidApiInterceptor rapidApiInterceptor) {
        return restTemplateBuilder
                .interceptors(rapidApiInterceptor)
                .build();
    }

}
