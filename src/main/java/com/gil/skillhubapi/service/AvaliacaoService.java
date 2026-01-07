package com.gil.skillhubapi.service;

import com.gil.skillhubapi.entity.Avaliacao;
import com.gil.skillhubapi.repository.AvaliacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;

    public List<Avaliacao> findAll() {
        return avaliacaoRepository.findAll();
    }

    public Avaliacao findById( Long id ) {
        return avaliacaoRepository.findById( id ).orElse( null );
    }

    public Avaliacao save( Avaliacao avaliacao) {
        return avaliacaoRepository.save( avaliacao );
    }

    public void delete( Long id ) {
        avaliacaoRepository.deleteById( id );
    }
}
