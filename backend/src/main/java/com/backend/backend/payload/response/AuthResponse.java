package com.backend.backend.payload.response;


import com.backend.backend.payload.DTO.UserDto.UserDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponse {
    
    private String message;

    private String  access_token;
    
    private String  refresh_token;

    private UserDto user;





}
