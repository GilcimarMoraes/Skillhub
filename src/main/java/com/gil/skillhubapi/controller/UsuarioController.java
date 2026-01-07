package com.gil.skillhubapi.controller;

import com.gil.skillhubapi.entity.Usuario;
import com.gil.skillhubapi.service.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag( name = "Usuário" )
@RequestMapping( "/usuario" )
public class UsuarioController {

    private final UsuarioService usuarioService;

    @ResponseStatus( HttpStatus.CREATED )
    @PostMapping
    public ResponseEntity<Usuario> save( @RequestBody Usuario usuario ) {
        return ResponseEntity.status(HttpStatus.CREATED).body( usuarioService.save( usuario) );
    }
}
