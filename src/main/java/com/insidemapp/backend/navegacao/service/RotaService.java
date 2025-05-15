package com.insidemapp.backend.navegacao.service;

import com.insidemapp.backend.estabelecimento.model.Estabelecimento;
import com.insidemapp.backend.estabelecimento.model.PontoDeInteresse;
import com.insidemapp.backend.estabelecimento.repository.IPontoDeInteresseRepository;
import com.insidemapp.backend.navegacao.model.Rota;
import com.insidemapp.backend.navegacao.repository.IRotaRepository;
import com.insidemapp.backend.estabelecimento.repository.IEstabelecimentoRepository;
import com.insidemapp.backend.navegacao.dto.RotaRequestDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RotaService {

    private final IRotaRepository rotaRepository;
    private final IEstabelecimentoRepository estabelecimentoRepository;
    private final IPontoDeInteresseRepository pontoRepository;

    public RotaService(IRotaRepository rotaRepository,
                       IEstabelecimentoRepository estabelecimentoRepository,
                       IPontoDeInteresseRepository pontoRepository) {
        this.rotaRepository = rotaRepository;
        this.estabelecimentoRepository = estabelecimentoRepository;
        this.pontoRepository = pontoRepository;
    }

    public Rota criar(RotaRequestDTO dto) {
        Estabelecimento estabelecimento = estabelecimentoRepository.findById(dto.getEstabelecimentoId())
                .orElseThrow(() -> new IllegalArgumentException("Estabelecimento não encontrado"));

        PontoDeInteresse origem = pontoRepository.findById(dto.getPontoOrigemId())
                .orElseThrow(() -> new IllegalArgumentException("Ponto de origem não encontrado"));

        PontoDeInteresse destino = pontoRepository.findById(dto.getPontoDestinoId())
                .orElseThrow(() -> new IllegalArgumentException("Ponto de destino não encontrado"));

        Rota rota = new Rota();
        rota.setEstabelecimento(estabelecimento);
        rota.setPontoOrigem(origem);
        rota.setPontoDestino(destino);
        rota.setCaminho(dto.getCaminho());
        rota.setTempoEstimado(dto.getTempoEstimado());

        return rotaRepository.save(rota);
    }

    public Optional<Rota> buscarPorId(Integer id) {
        return rotaRepository.findById(id);
    }
}