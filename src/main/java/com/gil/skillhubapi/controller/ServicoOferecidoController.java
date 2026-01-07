package com.gil.skillhubapi.controller;

import com.gil.skillhubapi.model.ServicoOferecido;
import com.gil.skillhubapi.service.ServicoOferecidoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping( "/servicoOferecido")
@RequiredArgsConstructor
@Tag( name = "Serviços Oferecidos" )
public class ServicoOferecidoController {

    private final ServicoOferecidoService servicoOferecidoService;

    @GetMapping
    public ResponseEntity<List<ServicoOferecido>> findAll() {
        return ResponseEntity.ok(servicoOferecidoService.findAll() );
    }

    @GetMapping( "/{id}")
    public ResponseEntity<ServicoOferecido> findById( @PathVariable Long id ) {
        return ResponseEntity.ok( servicoOferecidoService.findById( id ) );
    }

    @ResponseStatus( HttpStatus.CREATED )
    @PostMapping
    public ResponseEntity<ServicoOferecido> save( ServicoOferecido servicoOferecido) {
        return ResponseEntity.status( HttpStatus.CREATED ).body( servicoOferecidoService.save( servicoOferecido ) );
    }

    @ResponseStatus( HttpStatus.NO_CONTENT )
    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable Long id ) {
        servicoOferecidoService.deleteById( id );
    }
}
