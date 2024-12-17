package com.web.barbearia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.web.barbearia.model.Atendimento;
import java.time.LocalDateTime;


public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {
    @Query("SELECT a FROM Atendimento a WHERE a.data BETWEEN :start AND :end")
    List<Atendimento> findByDataBetween(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}
