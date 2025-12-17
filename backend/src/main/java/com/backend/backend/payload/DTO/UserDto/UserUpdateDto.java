package com.backend.backend.payload.DTO.UserDto;

import com.backend.backend.domain.Role;
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
