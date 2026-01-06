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
public class ServicoOferecidos {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @ManyToOne
    @JoinColumn( name = "servico_id" )
    private Servico servico;

    private String descricao;

    private String nome;

    private BigDecimal valor;

    @ManyToOne
    @JoinColumn( name = "usuario_id" )
    private Usuario usuario;

    private String descricao;

    private Boolean ativo;

    @Timestamp
    private LocalDate dataCriacao;

    @UpdateTimestamp
    private LocalDate dataAtualizacao;
}
