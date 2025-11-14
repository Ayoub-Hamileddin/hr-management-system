package com.backend.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.payload.DTO.LoginRequest;
import com.backend.backend.payload.DTO.RegisterRequest;
import com.backend.backend.payload.DTO.UserDto;
import com.backend.backend.payload.response.AuthResponse;
import com.backend.backend.service.AuthService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;



    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
       return ResponseEntity.ok(authService.login(loginRequest));
    }


    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest registerRequest) {
       return ResponseEntity.ok(authService.register(registerRequest));
    }


    @GetMapping("/me")
    public ResponseEntity<UserDto> me(@RequestHeader String jwt) {
       return ResponseEntity.ok(authService.me(jwt));
    }


    

}
