package com.igor.email_service.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendWelcomeEmail(String toEmail) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(toEmail);
        message.setSubject("Seja muito bem-vindo ao nosso sistema!");
        message.setText("Olá!\n\nO seu registo foi concluído com sucesso. Obrigado por se juntar a nós!");

       javaMailSender.send(message);
    }
}
