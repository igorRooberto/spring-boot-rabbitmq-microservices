package com.igor.email_service;

import com.igor.email_service.dto.RegisterInput;
import com.igor.email_service.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    private final EmailService emailService;

    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "email.queue")
    public void listenEmailQueue(RegisterInput event) {
        emailService.sendWelcomeEmail(event.email());
    }
}
