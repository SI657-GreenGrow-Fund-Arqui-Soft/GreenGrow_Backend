package com.greengrow.backend.service;

import com.greengrow.backend.domain.model.entity.Profile;
import com.greengrow.backend.dto.ProfileDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProfilePublisherService {
    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.routing.json.key}")
    private String routingKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfilePublisherService.class);
    private final RabbitTemplate rabbitTemplate;

    public ProfilePublisherService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishUser(Profile user) {
        ProfileDTO dto = new ProfileDTO(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getCellNumber(),
                user.getImage(),
                user.getRole()
        );
        LOGGER.info(String.format("Publishing user ID: %s", user.toString()));
        rabbitTemplate.convertAndSend(exchange, routingKey, dto);
    }
}
