package com.airiline.tickets.service;

import com.airiline.tickets.dto.event.EmailEvent;

public interface EmailService {
    void sendMessage(EmailEvent emailEvent);
}
