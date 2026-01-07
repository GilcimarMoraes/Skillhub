package com.gil.skillhubapi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    @Value( "${security.jwt.secret}")
    private String secret;

    @Value( "${security.jwt.expiration-minutes}")
    private long expirationMinutes;

    public String generateTokens( CustomUserDetails user) {

    }

}
