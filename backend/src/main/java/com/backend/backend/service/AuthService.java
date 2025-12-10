package com.backend.backend.service;

import com.backend.backend.payload.DTO.UserDto.UserDto;
import com.backend.backend.payload.DTO.authDto.LoginRequest;
import com.backend.backend.payload.DTO.authDto.RegisterRequest;
import com.backend.backend.payload.response.AuthResponse;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthService {

    AuthResponse login(LoginRequest loginRequest,HttpServletResponse response);

    AuthResponse register(RegisterRequest registerRequest);

    UserDto me();

    String logout(String refreshRequest);

    AuthResponse refreshAccessToken(String refreshToken);
}
