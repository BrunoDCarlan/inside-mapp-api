package com.insidemapp.backend.user.controller;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> criar(@RequestBody User user) {
        return ResponseEntity.ok(userService.criarUsuario(user));
    }
}
