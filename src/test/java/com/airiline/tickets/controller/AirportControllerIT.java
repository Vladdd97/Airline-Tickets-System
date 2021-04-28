package com.airiline.tickets.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;

import static com.airiline.tickets.controller.AirportController.AIRPORT_URL;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test-db")
@Transactional
public class AirportControllerIT extends BaseControllerIT {


    @Test
    void testCreateAirport_Success() throws Exception {
        mockMvc.perform(post(AIRPORT_URL)
                .content(readMockRequestFromFile("create-airport-request-success.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content()
                        .json(readMockResponseFromFile("create-airport-response-success.json"), false))
                .andExpect(jsonPath("id").isNumber());
    }

    @Test
    @Sql("/sql/insertAirport_101.sql")
    void testGetAirportById_Success() throws Exception {
        mockMvc.perform(get(AIRPORT_URL + "/{airportId}", 101))
                .andExpect(status().isOk())
                .andExpect(content()
                        .json(readMockResponseFromFile("get-airport-by-id-success.json"), true));
    }
}
