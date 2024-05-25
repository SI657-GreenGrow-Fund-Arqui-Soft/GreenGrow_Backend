package com.greengrow.backend.service.impl;

import com.greengrow.backend.domain.model.entity.Profile;
import com.greengrow.backend.domain.persistence.ProfileRepository;
import com.greengrow.backend.exception.ValidationException;
import com.greengrow.backend.service.ProfileService;
import lombok.AllArgsConstructor;
import org.hibernate.FetchNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProfileServiceImpl implements ProfileService {

    private ProfileRepository profileRepository;

    @Override
    public Profile updateProfile(Long id, Profile profile) {
        validateProfile(profile);
        profile.setId(id);
        if(profileRepository.findById(id).isPresent()){
            return profileRepository.save(profile);
        }
        throw new ValidationException("No se puede actualizar el usuario, id no valido");
    }

    @Override
    public Profile createProfile(Profile profile) {
        validateProfile(profile);
        if(profileRepository.findByEmail(profile.getEmail()).isEmpty() && profileRepository.findByCellNumber(profile.getCellNumber()).isEmpty()){
            return profileRepository.save(profile);
        }
        throw new ValidationException("No se puede crear el usuario, email o cellnumber ya existente");
    }

    @Override
    public Profile fetchById(Long id) {
        return profileRepository.findById(id).orElseThrow(()->new FetchNotFoundException("Profile", id));
    }

    @Override
    public boolean deleteById(Long id) {
        if (profileRepository.findById(id).isPresent()) {
            profileRepository.deleteById(id);
            return true;
        }
        return false;
    }



    private void validateProfile(Profile profile) {
        if (profile.getFirstName() == null || profile.getFirstName().isEmpty()) {
            throw new ValidationException("First name is required");
        }
        if (profile.getLastName() == null || profile.getLastName().isEmpty()) {
            throw new ValidationException("Last name is required");
        }
        if (profile.getEmail() == null || profile.getEmail().isEmpty()) {
            throw new ValidationException("Email is required");
        }
        if (profile.getCellNumber() == null || profile.getCellNumber().isEmpty()) {
            throw new ValidationException("Cell is required");
        }
    }
}
