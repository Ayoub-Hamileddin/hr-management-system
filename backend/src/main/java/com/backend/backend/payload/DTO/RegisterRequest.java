package com.backend.backend.payload.DTO;

import com.backend.backend.domain.Role;

import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class RegisterRequest {
    private String fullName;
   
    private String email;
    
    private String password;

    private Role role;

    private Boolean isActive;
}
