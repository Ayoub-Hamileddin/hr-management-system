package com.backend.backend.service;

import com.backend.backend.payload.DTO.LoginRequest;
import com.backend.backend.payload.DTO.RegisterRequest;
import com.backend.backend.payload.response.AuthResponse;

public interface AuthService {
    AuthResponse login(LoginRequest loginRequest);
    AuthResponse register(RegisterRequest registerRequest);
}
