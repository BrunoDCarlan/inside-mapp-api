package com.insidemapp.backend.estabelecimento.repository;

import com.insidemapp.backend.estabelecimento.model.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstabelecimentoRepository extends JpaRepository<Estabelecimento, Integer> {

}