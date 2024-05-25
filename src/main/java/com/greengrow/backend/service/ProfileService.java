package com.greengrow.backend.service;

import com.greengrow.backend.domain.model.entity.Profile;

public interface ProfileService {
    Profile updateProfile(Long id, Profile profile);
    Profile createProfile(Profile profile);
    Profile fetchById(Long id);
    boolean deleteById(Long id);
}
