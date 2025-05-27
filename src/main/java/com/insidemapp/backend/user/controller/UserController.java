package com.insidemapp.backend.user.controller;

import com.insidemapp.backend.user.dto.LoginRequestDTO;
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
    public ResponseEntity<User> criar(@RequestBody User user) {
        return ResponseEntity.ok(userService.criarUsuario(user));
    }

    @GetMapping("/listarusuarios")
    public ResponseEntity<List<User>> listar() {
        return ResponseEntity.ok(userService.buscarTodos());
    }

    @PostMapping("/entrar")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO login) {
        boolean sucesso = userService.autenticar(login.getEmail(), login.getSenha());

        if (sucesso) {
            return ResponseEntity.ok("Login realizado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas.");
        }
    }
}
