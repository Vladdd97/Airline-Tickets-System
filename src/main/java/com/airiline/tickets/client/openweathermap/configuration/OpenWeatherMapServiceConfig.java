package com.airiline.tickets.client.openweathermap.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "open-weather-map")
@Getter
@Setter
public class OpenWeatherMapServiceConfig {

    private String xRapidapiKey;
    private String xRapidapiHost;
    private String searchWeatherDataUrl;
}
