package com.airiline.tickets.client.openweathermap.configuration.interceptor;

import com.airiline.tickets.client.openweathermap.configuration.OpenWeatherMapServiceConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class RapidApiInterceptor implements ClientHttpRequestInterceptor {

    private final OpenWeatherMapServiceConfig weatherMapServiceConfig;

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes,
                                        ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {

        httpRequest.getHeaders().add("x-rapidapi-key", weatherMapServiceConfig.getXRapidapiKey());
        httpRequest.getHeaders().add("x-rapidapi-host", weatherMapServiceConfig.getXRapidapiHost());

        return clientHttpRequestExecution.execute(httpRequest, bytes);
    }
}
