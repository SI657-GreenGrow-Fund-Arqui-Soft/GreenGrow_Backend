package com.greengrow.backend.dto;

import com.greengrow.backend.domain.model.valueobject.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.io.Serializable;


@With
public record ProfileDTO (
        String firstName,
        String lastName,
        String email,
        String cellNumber,
        String image,
        Role role
) implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "ExternalUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", cellNumber='" + cellNumber + '\'' +
                ", image='" + image + '\'' +
                ", role=" + role +
                '}';
    }
}
