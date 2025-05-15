package com.insidemapp.backend.navegacao.model;

import com.insidemapp.backend.estabelecimento.model.*;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ROTA", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"estabelecimento_id", "ponto_origem_id", "ponto_destino_id"})
})
@Data
public class Rota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "estabelecimento_id")
    private Estabelecimento estabelecimento;

    @ManyToOne
    @JoinColumn(name = "ponto_origem_id")
    private PontoDeInteresse pontoOrigem;

    @ManyToOne
    @JoinColumn(name = "ponto_destino_id")
    private PontoDeInteresse pontoDestino;

    @Column(columnDefinition = "json")
    private String caminho;

    @Column(name = "tempo_estimado")
    private Integer tempoEstimado;
}