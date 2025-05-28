package com.insidemapp.backend.user.service;

import com.insidemapp.backend.user.model.User;
import com.insidemapp.backend.user.repository.IUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final IUserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    // Injeção via construtor
    public UserService(IUserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User criarUsuario(User user) {
        user.setSenhaHash(passwordEncoder.encode(user.getSenhaHash()));
        return userRepository.save(user);
    }

    public List<User> buscarTodos() {
        return userRepository.findAll();
    }

    public User buscarPorEmailESenha(String email, String senha) {
        boolean autenticado = autenticar(email, senha);
        if (!autenticado) return null;

        return userRepository.findByEmail(email).orElse(null);
    }

    private boolean  autenticar(String email, String senha) {
        Optional<User> usuario = userRepository.findByEmail(email);

        if (usuario.isEmpty()) {
            return false;
        }

        return passwordEncoder.matches(senha, usuario.get().getSenhaHash());
    }

}