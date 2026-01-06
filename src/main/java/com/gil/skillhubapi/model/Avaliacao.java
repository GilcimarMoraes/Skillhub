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
import org.hibernate.mapping.Join;

import java.time.LocalDate;

@Entity
@Table( name = "avaliacoes", schema = "skillhub" )
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Avaliacao {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @ManyToOne
    @JoinColumn( name = "solicitacao_servico_id" )
    private SolicitacaoServico solicitacaoServico;

    @ManyToOne
    @JoinColumn( name = "usuario_avaliador_id" )
    private Usuario usarioAvaliador;

    private Integer nota;

    private String comentario;

    @Timestamp
    private LocalDate dataCriacao;
}
