package com.backend.backend.service;

import com.backend.backend.model.RefreshToken;


public interface RefreshTokenService {
    
    RefreshToken createRefreshToken(Long userId,String refreshToken);

     void revokeToken(RefreshToken token);

    Boolean isExpired(RefreshToken token);

   
    
}
