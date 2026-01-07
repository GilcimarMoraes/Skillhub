package com.gil.skillhubapi.controller;

import com.gil.skillhubapi.entity.Servico;
import com.gil.skillhubapi.service.ServicoService;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag( name = "Servicos" )
@RestController
@RequiredArgsConstructor
@RequestMapping( "/servicos" )
public class ServicoController {

    private final ServicoService servicoService;

    @GetMapping
    public ResponseEntity<List<Servico>> findAll() {
        return ResponseEntity.ok( servicoService.findAll() );
    }

    @GetMapping( "/{id}")
    public ResponseEntity<Servico> findById( @PathVariable Long id) {
        return ResponseEntity.ok( servicoService.findById( id ));
    }

    @ResponseStatus( HttpStatus.CREATED )
    @PostMapping
    public ResponseEntity<Servico> save( @RequestBody Servico servico ) {
        return ResponseEntity.status(HttpStatus.CREATED).body( servicoService.save( servico ) );
    }

    @ResponseStatus( HttpStatus.NO_CONTENT )
    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable Long id ) {
        servicoService.delete( id );
    }
}
