package com.insidemapp.backend.estabelecimento.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ANDAR")
@Data
public class Andar {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "estabelecimento_id")
    private Estabelecimento estabelecimento;

    @Column(name = "numero_andar")
    private Integer numeroAndar;

    @Column(name = "nome_andar")
    private String nomeAndar;
}