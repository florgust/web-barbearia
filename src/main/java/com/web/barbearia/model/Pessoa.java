package com.web.barbearia.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pessoa")
@Data
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long codigo;

    private String nome;

    @Column(nullable = false)
    private String senha; // Senha deve estar criptografada

    private LocalDate nascimento;

    @Column(unique = true, nullable = false)
    private String email;

    private String telefone;

    /**
     * Tipo de usuário:
     * 1 = ADM
     * 2 = USER
     */
    private int tipo;
}
