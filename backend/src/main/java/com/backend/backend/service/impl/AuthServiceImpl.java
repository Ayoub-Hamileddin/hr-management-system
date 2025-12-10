package com.backend.backend.service.impl;

import com.backend.backend.Exceptions.BadRequestException;
import com.backend.backend.Exceptions.EmailAlreadyExsitException;
import com.backend.backend.Exceptions.NotFoundException;
import com.backend.backend.Exceptions.UnauthorizedException;
import com.backend.backend.config.JwtService;
import com.backend.backend.domain.Role;
import com.backend.backend.mapper.UserMapper;
import com.backend.backend.model.RefreshToken;
import com.backend.backend.model.User;
import com.backend.backend.payload.DTO.UserDto.UserDto;
import com.backend.backend.payload.DTO.authDto.LoginRequest;
import com.backend.backend.payload.DTO.authDto.RegisterRequest;
import com.backend.backend.payload.response.AuthResponse;
import com.backend.backend.repository.RefreshTokenRespository;
import com.backend.backend.repository.UserRepository;
import com.backend.backend.service.AuthService;
import com.backend.backend.service.RefreshTokenService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;
    private final RefreshTokenRespository refreshTokenRespository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Value("${jwt.refresh-token-expiration}")
    private Long refresh_token_expiration;
                //* login logic   */
    @Override
    public AuthResponse login(LoginRequest loginRequest,HttpServletResponse response) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(),
                loginRequest.getPassword())
        ) ;

        var user=userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(
            ()->new NotFoundException("user","User not Found")
        );
        if (!user.getIsActive()) {
            throw new UnauthorizedException("you're account is Blocked");
        }
        String access_token=jwtService.generateAccessToken(null, user);
        
        String refresh_token=jwtService.generateRefreshToken(null, user);

                     //* create and save the refresh_token  */
        refreshTokenService.createRefreshToken(user.getId(), refresh_token);


        ResponseCookie newRefreshToken=ResponseCookie.from("refreshToken",refresh_token)
        .httpOnly(true)
        .secure(true)
        .path("/")
        .sameSite("None")
        .maxAge(refresh_token_expiration)
        .build();

        response.addHeader("Set-Cookie", newRefreshToken.toString());

        return AuthResponse.builder()
            .access_token(access_token)
            .refresh_token(refresh_token)
            .message("Login Successfuly")
            .user(userMapper.toDto(user))

        .build();


    }


                    //* register logic   */
    @Override
    public AuthResponse register(RegisterRequest registerRequest) {

           if (userRepository.existsByEmail(registerRequest.getEmail())) {
               throw new EmailAlreadyExsitException("Email already exist");
            }
        
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

                //* create and save the refresh_token  */
       refreshTokenService.createRefreshToken(newUser.getId(), refresh_token);

       return AuthResponse.builder()
            .access_token(access_token)
            .refresh_token(refresh_token)
            .message("Register Successfuly")

       .build();

    }


      @Override
    public String logout(String refreshRequest) {
         RefreshToken token =  refreshTokenRespository.findByToken(refreshRequest)
                       .orElseThrow(()->new BadRequestException("invalid refreshToken"));

              refreshTokenService.revokeToken(token);

              return "logout Successfuly";
    }



                    //* get current user info   */
    @Override
    public UserDto me() {

        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        User user= userRepository.findByEmail(userDetails.getUsername()).get();
        return userMapper.toDto(user);

    }


    @Override
    public AuthResponse refreshAccessToken(String refreshToken) {
        RefreshToken token = refreshTokenRespository.findByToken(refreshToken)
        .orElseThrow(() -> new NotFoundException("refreshToken","Invalid refresh token"));

    if (token.getRevoked()) {
        throw new UnauthorizedException("Refresh token revoked");
    }

    if (refreshTokenService.isExpired(token)) {
        refreshTokenService.revokeToken(token);
        throw new UnauthorizedException("Refresh token expired, please login again");
    }

    User user = token.getUser();
    String newAccessToken = jwtService.generateAccessToken(null,user);
    
            AuthResponse authResponse= AuthResponse.builder()
                .access_token(newAccessToken)
                .refresh_token(token.getToken())
                .message("Refresh Access Token")
            .build();
        return authResponse;
    }





    

    

  
    
}
