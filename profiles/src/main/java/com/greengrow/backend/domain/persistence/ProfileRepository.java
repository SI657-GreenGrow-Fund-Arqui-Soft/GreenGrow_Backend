package com.greengrow.backend.domain.persistence;

import com.greengrow.backend.domain.model.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Boolean existsByEmail(String email);
    Optional<Profile> findById(Long id);
    Optional<Profile> findByEmail(String email);
    Optional<Profile> findByCellNumber(String cellNumber);
    Optional<Profile> findByFirstName(String firstName);
    Optional<Profile> findByLastName(String lastName);
    Optional<Profile> findByEmailAndFirstName(String email, String firstName);
}
