package com.insidemapp.backend.estabelecimento.service;

import com.insidemapp.backend.estabelecimento.model.Estabelecimento;
import com.insidemapp.backend.estabelecimento.repository.IEstabelecimentoRepository;
import org.springframework.stereotype.Service;

@Service
public class EstabelecimentoService {
    private final IEstabelecimentoRepository repository;

    public EstabelecimentoService(IEstabelecimentoRepository repository) {
        this.repository = repository;
    }

    public Estabelecimento salvar(Estabelecimento e) {
        return repository.save(e);
    }
}

