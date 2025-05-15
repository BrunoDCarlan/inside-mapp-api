package com.insidemapp.backend.estabelecimento.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MAPA")
@Data
public class Mapa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "estabelecimento_id")
    private Estabelecimento estabelecimento;

    private String nome;
    private String tipo;

    @Column(name = "url_arquivo")
    private String urlArquivo;
}