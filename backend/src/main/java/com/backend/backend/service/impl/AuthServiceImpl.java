package com.backend.backend.service.impl;

import org.springframework.stereotype.Service;

import com.backend.backend.payload.DTO.LoginRequest;
import com.backend.backend.payload.DTO.RegisterRequest;
import com.backend.backend.payload.response.AuthResponse;
import com.backend.backend.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

    @Override
    public AuthResponse register(RegisterRequest registerRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'register'");
    }
    
}
