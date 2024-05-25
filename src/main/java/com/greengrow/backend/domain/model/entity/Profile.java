package com.greengrow.backend.domain.model.entity;

import com.greengrow.backend.domain.model.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = true)
    private String firstName;

    @Column(name = "last_name", nullable = true)
    private String lastName;

    @Column(name= "email", nullable = false)
    private String email;

    @Column(name = "cell_number", nullable = true)
    private String cellNumber;

    @Column(name = "image", nullable = true)
    private String image;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;
}
