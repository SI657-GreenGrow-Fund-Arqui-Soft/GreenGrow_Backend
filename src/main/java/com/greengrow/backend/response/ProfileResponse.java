package com.greengrow.backend.response;

import com.greengrow.backend.domain.model.Role;
import lombok.Data;

@Data
public class ProfileResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String cellNumber;
    private String image;
    private Role role;
}
