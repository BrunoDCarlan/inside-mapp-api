package com.insidemapp.backend.navegacao.controller;

import com.insidemapp.backend.navegacao.dto.RotaRequestDTO;
import com.insidemapp.backend.navegacao.model.Rota;
import com.insidemapp.backend.navegacao.service.RotaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/rotas")
public class RotaController {

    private final RotaService rotaService;

    public RotaController(RotaService rotaService) {
        this.rotaService = rotaService;
    }

    @PostMapping
    public ResponseEntity<Rota> criar(@RequestBody RotaRequestDTO dto) {
        Rota rotaCriada = rotaService.criar(dto);
        return ResponseEntity.ok(rotaCriada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rota> buscarPorId(@PathVariable Integer id) {
        Optional<Rota> rota = rotaService.buscarPorId(id);
        return rota.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}