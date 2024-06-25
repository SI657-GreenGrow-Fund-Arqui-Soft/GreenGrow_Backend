package com.greengrow.backend.service.acl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greengrow.backend.domain.model.entity.Profile;
import com.greengrow.backend.domain.persistence.ProfileRepository;
import com.greengrow.backend.dto.ProfileDTO;
import com.greengrow.backend.service.ProfilePublisherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExternalProfileService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExternalProfileService.class);
    final private ProfilePublisherService profilePublisherService;
    final private ProfileRepository profileRepository;
    final private ObjectMapper objectMapper;
    public ExternalProfileService(ProfilePublisherService profilePublisherService, ProfileRepository profileRepository, ObjectMapper objectMapper) {
        this.profilePublisherService = profilePublisherService;
        this.profileRepository = profileRepository;
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    @Transactional
    public void fetchMessage(String userID) throws Exception {
        LOGGER.info(String.format("Recieved message of a user %s", userID));
        var cleanQuery = userID.replace("\"", "");
        Profile p;
        try {
            p = profileRepository.getById(Long.parseLong(cleanQuery));

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new Exception(e);
        }
        profilePublisherService.publishUser(p);
    }
    @RabbitListener(queues = {"${rabbitmq.queue.verify.name}"})
    @Transactional
    public String getProfile(String userId) throws Exception {
        LOGGER.info(String.format("Recieved message of a user %s", userId));
        var cleanQuery = userId.replace("\"", "");
        Profile p;
        try {
            p = profileRepository.getById(Long.parseLong(cleanQuery));
            ProfileDTO dto = new ProfileDTO(
                    p.getFirstName(),
                    p.getLastName(),
                    p.getEmail(),
                    p.getCellNumber(),
                    p.getImage(),
                    p.getRole()
            );

            return objectMapper.writeValueAsString(dto);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new Exception(e);
        }
    }

}
