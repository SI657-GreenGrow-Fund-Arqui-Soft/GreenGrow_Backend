package com.greengrow.backend.dto;

import com.greengrow.backend.domain.model.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Data
@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String cellNumber;
    private String image;

    @Enumerated(EnumType.STRING)
    private Role role;

}
