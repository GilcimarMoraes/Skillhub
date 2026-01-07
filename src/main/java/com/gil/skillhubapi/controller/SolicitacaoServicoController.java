package com.gil.skillhubapi.controller;

import com.gil.skillhubapi.entity.SolicitacaoServico;
import com.gil.skillhubapi.service.SolicitacaoServicoService;
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

@RestController
@RequestMapping( "/solicitacaoServico")
@RequiredArgsConstructor
@Tag( name = "Solicitação Serviço" )
public class SolicitacaoServicoController {

    private final SolicitacaoServicoService solicitacaoServicoService;

    @GetMapping
    public ResponseEntity<List<SolicitacaoServico>> findAll() {
        return ResponseEntity.ok( solicitacaoServicoService.findAll() );
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<SolicitacaoServico> findById( @PathVariable Long id ) {
        return ResponseEntity.ok( solicitacaoServicoService.findById( id ) );
    }

    @PostMapping
    @ResponseStatus( HttpStatus.CREATED )
    public ResponseEntity<SolicitacaoServico> save( @RequestBody SolicitacaoServico solicitacaoServico ) {
        return ResponseEntity.status( HttpStatus.CREATED ).body( solicitacaoServicoService.save( solicitacaoServico ) );
    }

    @DeleteMapping( "/{id}" )
    @ResponseStatus( HttpStatus.NO_CONTENT )
    public void delete(@PathVariable Long id ) {
        solicitacaoServicoService.deleteById( id );
    }
}
