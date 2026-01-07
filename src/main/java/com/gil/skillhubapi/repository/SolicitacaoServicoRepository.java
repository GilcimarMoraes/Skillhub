package com.gil.skillhubapi.repository;

import com.gil.skillhubapi.entity.SolicitacaoServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitacaoServicoRepository extends JpaRepository<SolicitacaoServico, Long> {
}
