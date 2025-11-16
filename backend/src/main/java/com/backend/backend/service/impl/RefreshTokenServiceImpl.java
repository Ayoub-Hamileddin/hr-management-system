package com.backend.backend.service.impl;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import com.backend.backend.model.RefreshToken;
import com.backend.backend.repository.RefreshTokenRespository;
import com.backend.backend.service.RefreshTokenService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private final RefreshTokenRespository refreshTokenRespository;

    @Value("${jwt.refresh-token-expiration}")
    private Long refresh_token_expiration;

    @Override
    public RefreshToken createRefreshToken(Long userId,String refreshToken) {

       var token=new RefreshToken();
       token.setToken(refreshToken);
       token.setUserId(userId);
       token.setRevoked(false);
       token.setExpireDate(new Date(System.currentTimeMillis() + refresh_token_expiration));
       token.setCreatedAt(LocalDateTime.now());


       return refreshTokenRespository.save(token);
    }


    @Override
    public Boolean revoke(RefreshToken token) {
        return token.getRevoked();
        
    }

    @Override
    public Boolean isExpired(RefreshToken token) {
        return token.getExpireDate().before(new Date());
    }

}
