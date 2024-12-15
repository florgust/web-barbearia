package com.web.barbearia.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "atendimento")
@Data
public class Atendimento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="gerador3", sequenceName = "atendimento_codigo_seq", allocationSize = 1)
    @GeneratedValue(generator="gerador3", strategy=GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "servico_id", nullable = false)
    private Servicos servico;

    private Double valor;
    private LocalDateTime data;
}