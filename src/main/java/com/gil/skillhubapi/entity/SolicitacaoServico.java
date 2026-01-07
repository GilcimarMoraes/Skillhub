package com.gil.skillhubapi.entity;

import com.gil.skillhubapi.enums.StatusSolicitacao;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

import java.time.LocalDate;

@Entity
@Table( name = "solicitacao_servico", schema = "skillhub" )
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SolicitacaoServico {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @ManyToOne
    @JoinColumn( name = "usuario_solicitante_id" )
    private Usuario usuarioSolicitante;

    @ManyToOne
    @JoinColumn( name = "usuario_prestador_id" )
    private Usuario usuarioPrestador;

    @ManyToOne
    @JoinColumn( name = "servico_oferecido_id")
    private ServicoOferecido servicoOferecido;

    @Enumerated( EnumType.STRING )
    private StatusSolicitacao status;

    @CreationTimestamp
    private LocalDate dataCriacao;

    private LocalDate dataRealizacao;
}
