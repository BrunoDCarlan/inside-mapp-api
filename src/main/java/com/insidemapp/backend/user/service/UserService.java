package com.insidemapp.backend.user.service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User criarUsuario(User user) {
        return userRepository.save(user);
    }
}