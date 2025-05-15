package com.insidemapp.backend.user.repository;

import com.insidemapp.backend.navegacao.model.Rota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<Rota, Integer> {
}
