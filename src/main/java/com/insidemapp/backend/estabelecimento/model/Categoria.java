package com.insidemapp.backend.estabelecimento.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "CATEGORIA")
@Data
public class Categoria {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String icone;
}
