package com.insidemapp.backend.user.controller;

import com.insidemapp.backend.user.dto.LoginRequestDTO;
import com.insidemapp.backend.user.dto.LoginResponseDTO;
import com.insidemapp.backend.user.dto.UserRegisterDTO;
import com.insidemapp.backend.user.model.User;
import com.insidemapp.backend.user.service.UserService;
import com.insidemapp.backend.infra.security.JwtTokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    public UserController(UserService userService, JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> criar(@RequestBody UserRegisterDTO dto) {
        User usuario = new User();
        usuario.setUsername(dto.getUsername());
        usuario.setEmail(dto.getEmail());
        usuario.setSenhaHash(dto.getSenhaHash());
        usuario.setTipo(dto.getTipo());

        usuario = userService.criarUsuario(usuario);

        if (usuario != null) {
            String token = jwtTokenProvider.generateToken(usuario.getEmail(), List.of(usuario.getTipo()));
            return ResponseEntity.ok(new LoginResponseDTO("Cadastro realizado com sucesso", usuario, token));
        } else {
            return ResponseEntity.internalServerError().body("Erro interno ao cadastrar usuário.");
        }
    }

    @PostMapping("/entrar")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO login) {
        User usuario = userService.buscarPorEmailESenha(login.getEmail(), login.getSenha());

        if (usuario != null) {
            String token = jwtTokenProvider.generateToken(usuario.getEmail(), List.of("ROLE_USER"));
            return ResponseEntity.ok(new LoginResponseDTO("Login realizado com sucesso", usuario, token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas.");
        }
    }

    @PostMapping("/guest")
    public ResponseEntity<LoginResponseDTO> entrarComoConvidado() {
        String token = jwtTokenProvider.generateToken("guest", List.of("ROLE_GUEST"));
        return ResponseEntity.ok(new LoginResponseDTO("Login como convidado realizado com sucesso", token));
    }

    @GetMapping("/listarusuarios")
    public ResponseEntity<List<User>> listar() {
        return ResponseEntity.ok(userService.buscarTodos());
    }
}
