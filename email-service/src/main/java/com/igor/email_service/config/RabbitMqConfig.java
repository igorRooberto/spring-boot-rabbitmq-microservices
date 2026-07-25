package com.igor.email_service.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static final String EMAIL_QUEUE = "email.queue";

    @Bean
    public Queue emailQueue(){
        return new Queue(EMAIL_QUEUE, true);
    }

    @Bean
    public MessageConverter jacksonJsonMessageConverter(){
        return new JacksonJsonMessageConverter();
    }
}
