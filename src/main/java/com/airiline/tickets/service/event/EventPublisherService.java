package com.airiline.tickets.service.event;

import com.airiline.tickets.configuration.event.EventConfig;
import com.airiline.tickets.dto.event.EmailEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventPublisherService {
    private final EventConfig eventConfig;

    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper;

    public void publishEmailEvent(EmailEvent emailEvent) throws JsonProcessingException {
        log.info("Publish emailEvent [{}]", emailEvent);

        var message = MessageBuilder
                .withBody(objectMapper.writeValueAsBytes(emailEvent))
                .build();

        amqpTemplate.send(eventConfig.getNotificationExchange(), eventConfig.getNotificationEmailRoutingKey(), message);
    }


}
