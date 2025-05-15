package com.insidemapp.backend.estabelecimento.controller;

import com.insidemapp.backend.estabelecimento.model.Estabelecimento;
import com.insidemapp.backend.estabelecimento.service.EstabelecimentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/estabelecimentos")
public class EstabelecimentoController {
    private final EstabelecimentoService service;

    public EstabelecimentoController(EstabelecimentoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Estabelecimento> criar(@RequestBody Estabelecimento dto) {
        return ResponseEntity.ok(service.salvar(dto));
    }
}