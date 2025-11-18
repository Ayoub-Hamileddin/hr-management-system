package com.backend.backend.service.impl;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.backend.backend.model.RefreshToken;
import com.backend.backend.model.User;
import com.backend.backend.repository.RefreshTokenRespository;
import com.backend.backend.repository.UserRepository;
import com.backend.backend.service.RefreshTokenService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private final RefreshTokenRespository refreshTokenRespository;
    private final UserRepository userRepository;

    @Value("${jwt.refresh-token-expiration}")
    private Long refresh_token_expiration;

    @Override
    public RefreshToken createRefreshToken(Long userId,String refreshToken) {

        User user=userRepository.findById(userId).orElseThrow();

       var token=new RefreshToken();
       token.setToken(refreshToken);
       token.setUser(user);
       token.setRevoked(false);
       token.setExpireDate(new Date(System.currentTimeMillis() + refresh_token_expiration));
       token.setCreatedAt(LocalDateTime.now());


       return refreshTokenRespository.save(token);
    }


    @Override
    public void revokeToken(RefreshToken token) {
       token.setRevoked(true);
       refreshTokenRespository.save(token);
        
    }

    @Override
    public Boolean isExpired(RefreshToken token) {
        return token.getExpireDate().before(new Date());
    }


}
