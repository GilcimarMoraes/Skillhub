package com.gil.skillhubapi.security;

import com.gil.skillhubapi.dto.JwtResponse;
import com.gil.skillhubapi.dto.LoginRequest;
import com.gil.skillhubapi.dto.RegisterRequest;
import com.gil.skillhubapi.entity.RefreshToken;
import com.gil.skillhubapi.entity.Usuario;
import com.gil.skillhubapi.repository.LoginHistoryRepository;
import com.gil.skillhubapi.repository.UsuarioRepository;
import com.gil.skillhubapi.service.JwtService;
import com.gil.skillhubapi.service.LoginHistoryService;
import com.gil.skillhubapi.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final LoginHistoryRepository loginHistoryRepository;
    private final LoginHistoryService loginHistoryService;

    public JwtResponse login( LoginRequest request ) {
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.email(), request.senha()));

        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();

        String accessToken = jwtService.generateTokens( user );

        RefreshToken refreshToken =
                refreshTokenService.create(user.getId() );

        loginHistoryService.save( user, accessToken );

        return new JwtResponse(accessToken, refreshToken.getToken());
    }

    public void register( RegisterRequest request ) {

        if( usuarioRepository.findByEmail(request.email()) != null ) {
            throw new RuntimeException("Email já cadastrado.");
        }

        Usuario usuario = new Usuario();
        usuario.setNome( request.nome() );
        usuario.setEmail( request.email() );
        usuario.setAtivo( Boolean.TRUE );
        usuario.setSenha( passwordEncoder.encode( request.senha() ) );

        usuarioRepository.save( usuario );
    }

}
