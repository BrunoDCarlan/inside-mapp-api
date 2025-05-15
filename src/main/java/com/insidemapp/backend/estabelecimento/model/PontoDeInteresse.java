package com.insidemapp.backend.estabelecimento.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PONTO_INTERESSE")
@Data
public class PontoDeInteresse {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "andar_id")
    private Andar andar;

    @ManyToOne
    @JoinColumn(name = "map_id")
    private Mapa mapa;

    private String nome;
    private String tipo;
    private String descricao;
    private String icone;

    @Column(name = "coordenada_x")
    private Double coordenadaX;

    @Column(name = "coordenada_y")
    private Double coordenadaY;

    @Column(name = "acessibilidade", columnDefinition = "json")
    private String acessibilidade;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @Column(name = "z_index")
    private Integer zIndex;
}
