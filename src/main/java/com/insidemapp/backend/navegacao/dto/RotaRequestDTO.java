package com.insidemapp.backend.navegacao.dto;

import lombok.Data;

@Data
public class RotaRequestDTO {
    private Integer estabelecimentoId;
    private Integer pontoOrigemId;
    private Integer pontoDestinoId;
    private String caminho;
    private Integer tempoEstimado;
}