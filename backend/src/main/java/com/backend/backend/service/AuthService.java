package com.backend.backend.service;

import com.backend.backend.payload.DTO.LoginRequest;
import com.backend.backend.payload.DTO.RefreshRequest;
import com.backend.backend.payload.DTO.RegisterRequest;
import com.backend.backend.payload.DTO.UserDto;
import com.backend.backend.payload.response.AuthResponse;

public interface AuthService {
    AuthResponse login(LoginRequest loginRequest);

    AuthResponse register(RegisterRequest registerRequest);

    UserDto me(String jwt);

    String logout(RefreshRequest refreshRequest);

    AuthResponse refreshAccessToken(String refreshToken);
}
