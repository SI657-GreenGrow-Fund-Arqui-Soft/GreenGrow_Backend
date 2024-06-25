package com.greengrow.backend.application.internal.outboundservices;


import com.greengrow.backend.application.internal.outboundservices.acl.ExternalUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class CoursePublisherService {
    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.routing.key}")
    private String routingKey;
    @Value("${rabbitmq.routing.verify.key}")
    private String verifyRoutingKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(CoursePublisherService.class);
    private final RabbitTemplate rabbitTemplate;

    public CoursePublisherService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishUserId(String userId) {
        LOGGER.info(String.format("Publishing user ID: %s", userId));
        rabbitTemplate.convertAndSend(exchange, routingKey, userId);
    }

    public boolean existsUser(String userId) {
        LOGGER.info(String.format("Publishing user ID: %s", userId));
        Object user = rabbitTemplate.convertSendAndReceive(exchange, verifyRoutingKey, userId);
        return user != null;
    }
}
