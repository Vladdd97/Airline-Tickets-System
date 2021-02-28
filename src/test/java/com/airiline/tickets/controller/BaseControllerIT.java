package com.airiline.tickets.controller;

import com.airiline.tickets.client.openweathermap.configuration.OpenWeatherMapRestTemplateConfiguration;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public abstract class BaseControllerIT {

    protected MockRestServiceServer mockOpenWeatherMapServer;

    @Qualifier(OpenWeatherMapRestTemplateConfiguration.OPEN_WEATHER_MAP_REST_TEMPLATE_BEAN)
    @Autowired
    private RestTemplate openWeatherMapRestTemplate;

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private ResourceLoader resourceLoader;

    @BeforeEach
    public void init() {
        mockOpenWeatherMapServer = MockRestServiceServer.createServer(openWeatherMapRestTemplate);
    }


    protected String readMockRequestFromFile(String fileName) throws IOException {
        return readFile("classpath:/mock-request/" + fileName);
    }

    protected String readMockResponseFromFile(String fileName) throws IOException {
        return readFile("classpath:/expected-response/" + fileName);
    }

    protected String readOpenWeatherMapMockResponseFromFile(String fileName) throws IOException {
        return readFile("classpath:/open-weather-map-response/" + fileName);
    }

    private String readFile(String path) throws IOException {
        val resource = resourceLoader.getResource(path);
        return new String(Files.readAllBytes(resource.getFile().toPath()));
    }

}
