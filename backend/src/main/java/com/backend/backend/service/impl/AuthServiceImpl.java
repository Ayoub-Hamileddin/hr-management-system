package com.backend.backend.service.impl;

import java.time.LocalDateTime;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.backend.config.JwtService;
import com.backend.backend.domain.Role;
import com.backend.backend.mapper.UserMapper;
import com.backend.backend.model.User;
import com.backend.backend.payload.DTO.LoginRequest;
import com.backend.backend.payload.DTO.RegisterRequest;
import com.backend.backend.payload.DTO.UserDto;
import com.backend.backend.payload.response.AuthResponse;
import com.backend.backend.repository.UserRepository;
import com.backend.backend.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;


                //* login logic   */
    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(),
                loginRequest.getPassword())
        ) ;

        var user=userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(
            ()->new UsernameNotFoundException("User not Found")
        );
        String access_token=jwtService.generateAccessToken(null, user);
        
        String refresh_token=jwtService.generateRefreshToken(null, user);

        return AuthResponse.builder()
            .access_token(access_token)
            .refresh_token(refresh_token)
            .message("Login Successfuly")
            .userDto(userMapper.toDto(user))

        .build();


    }


                    //* register logic   */
    @Override
    public AuthResponse register(RegisterRequest registerRequest) {

       var user=User.builder()
            .firstName(registerRequest.getFirstName())
            .lastName(registerRequest.getLastName())
            .email(registerRequest.getEmail())
            .password(passwordEncoder.encode(registerRequest.getPassword()))
            .role(Role.ROLE_EMPLOYEE)
            .isActive(true)
            .createdAt(LocalDateTime.now())
            .updatedAt(null)
       .build();

       User newUser=userRepository.save(user);


       String access_token=jwtService.generateAccessToken(null, user);
        
       String refresh_token=jwtService.generateRefreshToken(null, user);

       return AuthResponse.builder()
            .access_token(access_token)
            .refresh_token(refresh_token)
            .message("Register Successfuly")
            .userDto(userMapper.toDto(newUser))

       .build();

    }




                    //* get current user info   */
    @Override
    public UserDto me(String jwt) {

       String userEmail=jwtService.extractUserName(jwt);

        User connectedUser=userRepository.findByEmail(userEmail).orElseThrow(
            ()->new UsernameNotFoundException("Current User Not Found")
        );


        return userMapper.toDto(connectedUser);

    }
    
}
