package com.web.barbearia.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "pessoa")
@Data
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="gerador1", sequenceName = "pessoa_codigo_seq", allocationSize = 1)
    @GeneratedValue(generator="gerador1", strategy=GenerationType.SEQUENCE)
    private Long codigo;
    private String nome;
    private String senha;
    private LocalDate nascimento;
    private String email;
    private String telefone;
    private String TipoPessoa;
}
