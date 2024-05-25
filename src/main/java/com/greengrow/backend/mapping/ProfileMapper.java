package com.greengrow.backend.mapping;

import com.greengrow.backend.domain.model.entity.Profile;
import com.greengrow.backend.dto.ProfileDTO;
import com.greengrow.backend.response.ProfileResponse;
import com.greengrow.backend.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class ProfileMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;
    public Profile toEntity(ProfileDTO profileDTO) {return this.mapper.map(profileDTO, Profile.class);}
    public ProfileResponse toResponse(Profile profile) {return this.mapper.map(profile, ProfileResponse.class);}
}
