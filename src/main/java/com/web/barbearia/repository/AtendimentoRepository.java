package com.web.barbearia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.barbearia.model.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {
    
}
