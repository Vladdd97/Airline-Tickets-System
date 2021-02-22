package com.airiline.tickets.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ActiveProfiles("test-db")
@Transactional
public class TicketControllerIT extends BaseControllerIT {

    private static final String TICKET_BASE_PATH = "/v1/ats/tickets";
    private static final String GET_TICKET_BY_ID_PATH = TICKET_BASE_PATH + "/{ticketId}";

    @Test
    void testCreateTicket_Success() throws Exception {
        mockMvc.perform(post(TICKET_BASE_PATH)
                .content(readMockRequestFromFile("create-ticket-request-success.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content()
                        .json(readMockResponseFromFile("create-ticket-response-success.json"), false))
                .andExpect(jsonPath("id").isNumber());
    }

    @Test
    @Sql("/sql/insertTicket_101.sql")
    void testGetTicketById_Success() throws Exception {
        mockMvc.perform(get(GET_TICKET_BY_ID_PATH, 101))
                .andExpect(status().isOk())
                .andExpect(content()
                        .json(readMockResponseFromFile("get-ticket-by-id-success.json"), true));
    }

    @Test
    void testGetTicketById_NotFound_Error() throws Exception {
        mockMvc.perform(get(GET_TICKET_BY_ID_PATH, 101))
                .andExpect(status().isNotFound())
                .andExpect(content()
                        .json(readMockResponseFromFile("get-ticket-by-id-not-found-error.json"), true));
    }

}
