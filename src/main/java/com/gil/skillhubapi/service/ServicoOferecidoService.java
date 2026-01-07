package com.gil.skillhubapi.service;

import com.gil.skillhubapi.entity.ServicoOferecido;
import com.gil.skillhubapi.repository.ServicoOferecidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicoOferecidoService {

    private final ServicoOferecidoRepository servicoOferecidoRepository;

    public List<ServicoOferecido> findAll() {
        return servicoOferecidoRepository.findAll();
    }

    public ServicoOferecido findById( Long id ) {
        return servicoOferecidoRepository.findById( id ).orElse( null );
    }

    public ServicoOferecido save( ServicoOferecido servicoOferecido) {
        return servicoOferecidoRepository.save( servicoOferecido);
    }

    public void deleteById( Long id ) {
        servicoOferecidoRepository.deleteById( id );
    }
}
