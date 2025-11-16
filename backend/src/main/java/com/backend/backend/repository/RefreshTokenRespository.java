package com.backend.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.backend.model.RefreshToken;



public interface RefreshTokenRespository extends JpaRepository<RefreshToken,Long> {
    Optional<RefreshToken> findByToken(String token);
}
