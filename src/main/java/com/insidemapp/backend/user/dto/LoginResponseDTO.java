package com.insidemapp.backend.user.dto;

import com.insidemapp.backend.user.model.User;
import lombok.Data;

@Data
public class LoginResponseDTO {
    private String mensagem;
    private User usuario;

    public LoginResponseDTO(String mensagem, User usuario) {
        this.mensagem = mensagem;
        this.usuario = usuario;
    }
}