package com.gil.skillhubapi.service;

import com.gil.skillhubapi.model.SolicitacaoServico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitacaoServicoRepository extends JpaRepository<SolicitacaoServico, Long> {
}
