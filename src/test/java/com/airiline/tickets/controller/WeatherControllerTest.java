package com.airiline.tickets.controller;

import com.airiline.tickets.weatherapi.config.OpenWeatherMapServiceConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.ExpectedCount;

import java.io.IOException;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class WeatherControllerTest extends BaseControllerIT {

    private static final String GET_WEATHER_BY_CITY_NAME = "/v1/ats/weather/{city}";

    @Autowired
    private OpenWeatherMapServiceConfig openWeatherMapServiceConfig;

    @Test
    void testGetWeatherByCityName_Success() throws Exception {
        mockOpenWeatherMapServerResponse("get-weather-by-city-name-success.json");

        mockMvc.perform(get(GET_WEATHER_BY_CITY_NAME, "Chisinau"))
                .andExpect(status().isOk())
                .andExpect(content()
                        .json(readMockResponseFromFile("get-weather-by-city-name-success.json"), true));
    }

    private void mockOpenWeatherMapServerResponse(final String responseFile) throws IOException {
        mockOpenWeatherMapServer.expect(ExpectedCount.once(),
                requestTo(String.format(openWeatherMapServiceConfig.getSearchWeatherDataUrl(), "Chisinau")))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(readOpenWeatherMapMockResponseFromFile(responseFile)));
    }


}
