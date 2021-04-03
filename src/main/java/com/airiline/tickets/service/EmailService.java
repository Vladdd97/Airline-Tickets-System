package com.airiline.tickets.service;

public interface EmailService {
    void sendMessage(String to, String subject, String message);
}
