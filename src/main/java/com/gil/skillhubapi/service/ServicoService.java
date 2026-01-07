package com.gil.skillhubapi.service;

import com.gil.skillhubapi.entity.Servico;
import com.gil.skillhubapi.repository.ServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicoService {

    private final ServicoRepository servicoRepository;

    public List<Servico> findAll() {
        return servicoRepository.findAll();
    }

    public Servico findById( Long id ) {
        return servicoRepository.findById( id ).orElse( null );
    }

    public Servico save( Servico servico ) {
        return servicoRepository.save( servico );
    }

    public void delete( Long id ) {
        servicoRepository.deleteById( id );
    }
}
