package com.backend.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.payload.DTO.UserDto.UserDto;
import com.backend.backend.payload.DTO.authDto.LoginRequest;
import com.backend.backend.payload.DTO.authDto.RefreshRequest;
import com.backend.backend.payload.DTO.authDto.RegisterRequest;
import com.backend.backend.payload.response.AuthResponse;
import com.backend.backend.service.AuthService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
   
    private final AuthService authService;
    @Value("${jwt.refresh-token-expiration}")
    private Long refresh_token_expiration;


    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest loginRequest,HttpServletResponse response) {
       return ResponseEntity.ok(authService.login(loginRequest,response));
    }


    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest registerRequest) {
       return ResponseEntity.ok(authService.register(registerRequest));
    }


    @PostMapping("/logout")
    public ResponseEntity<String> logout(@Valid @CookieValue("refreshToken") String  refreshRequest){
         if (refreshRequest==null) {
               return ResponseEntity.badRequest().body("Refresh token is required");
         }

         return ResponseEntity.ok(authService.logout(refreshRequest));
    }




    @GetMapping("/me")
    public ResponseEntity<UserDto> me() {
       return ResponseEntity.ok(authService.me());
    }


    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@CookieValue("refreshToken") String  refreshRequest ){
    

        AuthResponse response = authService.refreshAccessToken(refreshRequest);

        ResponseCookie newRefreshCookie=ResponseCookie.from("refreshToken", response.getRefresh_token())
               .httpOnly(true)
               .secure(true)
               .path("/")
               .sameSite("None")
               .maxAge(refresh_token_expiration)
               .build();
               
         return ResponseEntity.ok()
                                .header(HttpHeaders.SET_COOKIE, newRefreshCookie.toString())
                                .body(response);

   
    }


    

}
