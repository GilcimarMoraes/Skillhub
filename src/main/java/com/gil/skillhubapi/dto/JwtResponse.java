package com.gil.skillhubapi.dto;

public record JwtResponse(
        String accessToken,
        String refreshToken
) {
}
