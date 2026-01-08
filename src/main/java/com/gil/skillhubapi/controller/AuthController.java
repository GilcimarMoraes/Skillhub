package com.gil.skillhubapi.controller;

import com.gil.skillhubapi.dto.JwtResponse;
import com.gil.skillhubapi.dto.LoginRequest;
import com.gil.skillhubapi.dto.RegisterRequest;
import com.gil.skillhubapi.security.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping( "/auth" )
@Tag( name = "Auth" )
public class AuthController {

    private final AuthService authService;

    @PostMapping( "/login" )
    public JwtResponse login( @RequestBody LoginRequest request ) {
        return authService.login( request );
    }

    @PostMapping( "/register" )
    public ResponseEntity<Void> register( @RequestBody RegisterRequest request ) {
        authService.register( request );
        return ResponseEntity.status( HttpStatus.CREATED ).build();
    }

}
