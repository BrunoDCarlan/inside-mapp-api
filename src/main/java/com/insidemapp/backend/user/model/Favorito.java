package com.insidemapp.backend.user.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import com.insidemapp.backend.estabelecimento.model.PontoDeInteresse;
import lombok.Data;

@Entity
@Table(name = "FAVORITO")
@Data
public class Favorito {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = true)
    private User usuario;

    @ManyToOne
    @JoinColumn(name = "ponto_id")
    private PontoDeInteresse ponto;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    @Column(name = "token_sessao")
    private String tokenSessao;

    // getters/setters
}