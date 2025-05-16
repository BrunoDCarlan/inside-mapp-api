package com.insidemapp.backend.user.model;

import com.insidemapp.backend.estabelecimento.model.PontoDeInteresse;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "COMPARTILHAMENTO")
@Data
public class Compartilhamento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User usuario;

    @ManyToOne
    @JoinColumn(name = "ponto_id")
    private PontoDeInteresse ponto;

    @Column(name = "link_gerado")
    private String linkGerado;

    @Column(name = "data_compartilhamento")
    private LocalDateTime dataCompartilhamento;
}
