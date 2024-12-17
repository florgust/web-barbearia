package com.web.barbearia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.barbearia.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Optional<Pessoa> findByEmail(String email);
}
