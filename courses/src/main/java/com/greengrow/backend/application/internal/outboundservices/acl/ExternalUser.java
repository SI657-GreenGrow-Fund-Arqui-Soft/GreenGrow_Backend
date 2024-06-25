package com.greengrow.backend.application.internal.outboundservices.acl;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.With;

import java.io.Serializable;

@With
public record ExternalUser (
        String firstName,
        String lastName,
        String email,
        String cellNumber,
        String image,
        ExternalRole role
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