package com.airiline.tickets.service.event;

import com.airiline.tickets.dto.event.EmailEvent;
import com.airiline.tickets.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationEventListener {

    private final EmailService emailService;

    @RabbitListener(
            queues = "${event.email-queue}"
    )
    public void processEmailEvent(@Payload EmailEvent emailEvent) {
        log.info("Received emailEvent [{}]", emailEvent);
        emailService.sendMessage(emailEvent);
    }
}
