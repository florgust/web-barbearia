package com.web.barbearia.model;

import java.io.Serializable;
import java.time.Duration;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "servicos")
@Data
public class Servicos implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="gerador2", sequenceName = "servicos_codigo_seq", allocationSize = 1)
    @GeneratedValue(generator="gerador2", strategy=GenerationType.SEQUENCE)
    private Long id;
    private String descricao;
    private Double preco;
    private Duration tempoDuracao;
}