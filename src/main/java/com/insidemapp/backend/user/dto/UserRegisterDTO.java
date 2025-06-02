package com.insidemapp.backend.user.dto;

import lombok.Data;

@Data
public class UserRegisterDTO {
    private String username;
    private String email;
    private String senhaHash;
    private String tipo;
}
