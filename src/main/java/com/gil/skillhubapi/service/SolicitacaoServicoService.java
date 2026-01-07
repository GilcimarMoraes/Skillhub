package com.gil.skillhubapi.service;

import com.gil.skillhubapi.entity.SolicitacaoServico;
import com.gil.skillhubapi.repository.SolicitacaoServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SolicitacaoServicoService {

    private final SolicitacaoServicoRepository solicitacaoServicoRepository;

    public List<SolicitacaoServico> findAll() {
        return solicitacaoServicoRepository.findAll();
    }

    public SolicitacaoServico findById( Long id ) {
        return solicitacaoServicoRepository.findById( id ).orElse( null );
    }

    public SolicitacaoServico save( SolicitacaoServico solicitacaoServico ) {
        return solicitacaoServicoRepository.save( solicitacaoServico );
    }

    public void deleteById( Long id ) {
        solicitacaoServicoRepository.deleteById( id );
    }
}
