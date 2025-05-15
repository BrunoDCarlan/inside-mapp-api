package com.insidemapp.backend.navegacao.repository;

import com.insidemapp.backend.navegacao.model.Rota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRotaRepository extends JpaRepository<Rota, Integer> {
}
