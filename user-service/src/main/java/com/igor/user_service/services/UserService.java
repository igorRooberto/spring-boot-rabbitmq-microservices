package com.igor.user_service.services;

import com.igor.user_service.config.RabbitMqConfig;
import com.igor.user_service.dto.RegisterInput;
import com.igor.user_service.entities.User;
import com.igor.user_service.repository.UserRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RabbitTemplate rabbitTemplate;

    public UserService(UserRepository userRepository, RabbitTemplate rabbitTemplate) {
        this.userRepository = userRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    public void registerUser(RegisterInput input){
        if(userRepository.existsByEmail(input.email())){
           throw new RuntimeException("Email Já utilizado");
        }

        User newUser = new User(input.email());

        userRepository.save(newUser);
        rabbitTemplate.convertAndSend("email.queue", input);
    }

}
