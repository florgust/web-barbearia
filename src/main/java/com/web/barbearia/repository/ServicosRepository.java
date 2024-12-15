package com.web.barbearia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.barbearia.model.Servicos;

public interface ServicosRepository extends JpaRepository<Servicos, Long> {
    
}
