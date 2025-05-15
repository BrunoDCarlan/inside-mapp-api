package com.insidemapp.backend.estabelecimento.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ESTABELECIMENTO")
@Data
public class Estabelecimento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String descricao;
    private String tipo;

    @Column(name = "imagem_capa")
    private String imagemCapa;

    private String rua;
    private String numero;
    private String cep;
    private String bairro;
    private String cidade;
    private String uf;
    private String pais;

    @Column(name = "coordenada_lat")
    private Double coordenadaLat;

    @Column(name = "coordenada_long")
    private Double coordenadaLong;

    @Column(name = "total_andares")
    private Integer totalAndares;

    @Column(name = "nivel_acessibilidade")
    private Integer nivelAcessibilidade;

    @Column(name = "horario_funcionamento", columnDefinition = "json")
    private String horarioFuncionamento;
}