package com.gil.skillhubapi.controller;

import com.gil.skillhubapi.model.Avaliacao;
import com.gil.skillhubapi.service.AvaliacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "/avaliacoes" )
@RequiredArgsConstructor
public class AvaliacaoController {

    private final AvaliacaoService avaliacaoService;

    @GetMapping
    public ResponseEntity<List<Avaliacao>> findAll() {
        return ResponseEntity.ok( avaliacaoService.findAll() );
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<Avaliacao> findById( @PathVariable Long id ) {
        return ResponseEntity.ok( avaliacaoService.findById( id ) );
    }

    @PostMapping
    public ResponseEntity<Avaliacao> save( @RequestBody Avaliacao avaliacao ) {
        return ResponseEntity.status(HttpStatus.CREATED).body( avaliacaoService.save( avaliacao ) );
    }

    @ResponseStatus( HttpStatus.NO_CONTENT )
    @DeleteMapping( "/{id}")
    public void delete( @PathVariable Long id ) {
        avaliacaoService.delete( id );
    }
}
