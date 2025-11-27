package com.backend.backend.payload.DTO;

import java.time.LocalDateTime;

import com.backend.backend.domain.Role;

import lombok.Data;


@Data
public class UserDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;
    
    private Role role;

    private Boolean isActive;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
