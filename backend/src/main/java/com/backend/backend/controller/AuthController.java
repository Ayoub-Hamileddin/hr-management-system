package com.backend.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.config.JwtService;
import com.backend.backend.model.User;
import com.backend.backend.payload.DTO.LoginRequest;
import com.backend.backend.payload.DTO.RefreshRequest;
import com.backend.backend.payload.DTO.RegisterRequest;
import com.backend.backend.payload.DTO.UserDto;
import com.backend.backend.payload.response.AuthResponse;
import com.backend.backend.repository.RefreshTokenRespository;
import com.backend.backend.repository.UserRepository;
import com.backend.backend.service.AuthService;
import com.backend.backend.service.RefreshTokenService;

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
    private final JwtService jwtService;
    private final RefreshTokenRespository refreshTokenRespository;                
    private final UserRepository userRepository;              
    private final RefreshTokenService refreshTokenService;



    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
       return ResponseEntity.ok(authService.login(loginRequest));
    }


    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest registerRequest) {
       return ResponseEntity.ok(authService.register(registerRequest));
    }


    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody RefreshRequest refreshRequest){
         if (refreshRequest==null) {
               return ResponseEntity.badRequest().body("Refresh token is required");
         }

         return ResponseEntity.ok(authService.logout(refreshRequest));
    }





    @GetMapping("/me")
    public ResponseEntity<UserDto> me(@RequestHeader("Authorization") String jwt) {
       return ResponseEntity.ok(authService.me(jwt));
    }


    @PostMapping("/refresh")
    public ResponseEntity<String> refreshToken(@RequestBody RefreshRequest refreshRequest ){
      return refreshTokenRespository.findByToken(refreshRequest.getToken())
      .map(token -> {
         if (refreshTokenService.isExpired(token) || refreshTokenService.revoke(token)) {
               refreshTokenRespository.delete(token);
                return ResponseEntity.badRequest().body("Refresh Token expired ,please login again");
         }
         User user=userRepository.findById(token.getUserId()).orElseThrow();
         String newJwt=jwtService.generateAccessToken(null, user);

          return ResponseEntity.ok(newJwt);
      }).orElse(ResponseEntity.badRequest().body("Invalid Refresh Token"));
    }


    

}
