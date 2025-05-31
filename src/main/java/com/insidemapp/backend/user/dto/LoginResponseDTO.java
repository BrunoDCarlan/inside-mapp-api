package com.insidemapp.backend.user.dto;

import com.insidemapp.backend.user.model.User;
import lombok.Data;

@Data
public class LoginResponseDTO {
    private String mensagem;
    private User usuario;
    private String token;

    public LoginResponseDTO(String mensagem, User usuario, String token) {
        this.mensagem = mensagem;
        this.usuario = usuario;
        this.token = token;
    }

    public LoginResponseDTO(String mensagem, String token) {
        this.mensagem = mensagem;
        this.token = token;
    }
}