package com.gil.skillhubapi.repository;

import com.gil.skillhubapi.model.ServicoOferecido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoOferecidoRepository extends JpaRepository<ServicoOferecido, Long> {
}
