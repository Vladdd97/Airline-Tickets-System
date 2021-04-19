package com.airiline.tickets.configuration.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "event")
@Getter
@Setter
public class EventConfig {
    private String notificationExchange;
    private String emailQueue;
    private String notificationEmailRoutingKey;
}
