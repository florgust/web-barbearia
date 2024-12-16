package com.web.barbearia.model.enums;

import lombok.Getter;

@Getter
public enum TipoPessoa {
    USER(2),
    ADM(1);

    private int value;

    private TipoPessoa(int value) {
        this.value = value;
    }

    public static TipoPessoa fromValue(int value) {
        for (TipoPessoa tipo : TipoPessoa.values()) {
            if (tipo.getValue() == value) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Valor inválido: " + value);
    }
}
