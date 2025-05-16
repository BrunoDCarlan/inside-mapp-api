package com.insidemapp.backend.user.service;

import com.insidemapp.backend.user.model.User;
import com.insidemapp.backend.user.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User criarUsuario(User user) {
        return userRepository.save(user);
    }

    public List<User> buscarTodos() {
        return userRepository.findAll();
    }
}