package com.airiline.tickets.service.impl;

import com.airiline.tickets.dto.event.EmailEvent;
import com.airiline.tickets.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    @Override
    public void sendMessage(EmailEvent emailEvent) {
        log.info("Send email to [{}] with message [{}].", emailEvent.getTo(), emailEvent.getMessage());

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(emailEvent.getTo());
        simpleMailMessage.setSubject(emailEvent.getSubject());
        simpleMailMessage.setText(emailEvent.getMessage());
        javaMailSender.send(simpleMailMessage);
    }
}
