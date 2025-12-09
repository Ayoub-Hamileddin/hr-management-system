package com.backend.backend.payload.DTO.UserDto;

import java.time.LocalDateTime;

import com.backend.backend.domain.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class UserUpdateDto {

    private String firstName;

    private String lastName;

    private String email;

    private Boolean isActive;

    private String  password;

    private Role role;
}
