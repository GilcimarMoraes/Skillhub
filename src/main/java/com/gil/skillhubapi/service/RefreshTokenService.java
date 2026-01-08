package com.gil.skillhubapi.service;

import com.gil.skillhubapi.entity.RefreshToken;
import com.gil.skillhubapi.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    @Value("${security.jwt.expiration-minutes}")

    private long refreshExpiration;

    public RefreshToken create(Long userId) {
        RefreshToken token = new RefreshToken();
        token.setUserId(userId);
        token.setToken(UUID.randomUUID().toString());
        token.setExpiryDate( LocalDateTime.now().plusMinutes(refreshExpiration));

        token.setRevoked(false);
        return refreshTokenRepository.save(token);
    }
}
