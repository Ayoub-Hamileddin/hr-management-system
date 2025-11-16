package com.backend.backend.service;

import com.backend.backend.model.RefreshToken;

public interface RefreshTokenService {
    
    RefreshToken createRefreshToken(Long userId,String refreshToken);

    Boolean revoke(RefreshToken token);

    Boolean isExpired(RefreshToken token);
    
}
