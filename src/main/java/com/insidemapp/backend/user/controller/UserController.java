package com.insidemapp.backend.user.controller;

import com.insidemapp.backend.user.dto.LoginRequestDTO;
import com.insidemapp.backend.user.dto.LoginResponseDTO;
import com.insidemapp.backend.user.model.User;
import com.insidemapp.backend.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> criar(@RequestBody User user) {
        User usuario = userService.criarUsuario(user);

        if (usuario != null) {
            return ResponseEntity.ok(new LoginResponseDTO("Cadastro realizado com sucesso", usuario));
        } else {
            return ResponseEntity.internalServerError().body("Erro interno ao cadastrar usuário.");
        }
    }

    @GetMapping("/listarusuarios")
    public ResponseEntity<List<User>> listar() {
        return ResponseEntity.ok(userService.buscarTodos());
    }

    @PostMapping("/entrar")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO login) {
        User usuario = userService.buscarPorEmailESenha(login.getEmail(), login.getSenha());

        if (usuario != null) {
            return ResponseEntity.ok(new LoginResponseDTO("Login realizado com sucesso", usuario));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas.");
        }
    }
}
