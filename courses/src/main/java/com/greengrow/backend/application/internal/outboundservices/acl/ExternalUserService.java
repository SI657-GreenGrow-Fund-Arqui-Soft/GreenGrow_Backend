package com.greengrow.backend.application.internal.outboundservices.acl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ExternalUserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExternalUserService.class);

    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void fetchUser(ExternalUser user) {
        LOGGER.info(String.format("Recieved message of a user object -> %s", user));
    }

}
