package com.gil.skillhubapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
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

    private String nome;

    private String descricao;

    private BigDecimal valor;

    @ManyToOne
    @JoinColumn( name = "servico_id" )
    private Servico servico;


    @ManyToOne
    @JoinColumn( name = "usuario_id" )
    private Usuario usuario;

    private Boolean ativo;

    @CreationTimestamp
    private LocalDate dataCriacao;

    @UpdateTimestamp
    private LocalDate dataAtualizacao;
}
