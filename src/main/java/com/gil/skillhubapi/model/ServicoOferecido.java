package com.gil.skillhubapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table( name = "servicos_oferecidos", schema = "skillhub" )
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ServicoOferecido {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    private String ativo;

    private String descricao;

    private String nome;

    private BigDecimal valor;

    @ManyToOne
    @JoinColumn( name = "usuario_id" )
    private Usuario usuario;

    @ManyToOne
    @JoinColumn( name = "servico_id" )
    private Servico servico;

    @Timestamp
    private LocalDate dataCriacao;

    @UpdateTimestamp
    private LocalDate dataAtualizacao;
}
