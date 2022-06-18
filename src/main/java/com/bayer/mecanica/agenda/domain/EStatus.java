package com.bayer.mecanica.agenda.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EStatus {
    AGENDADO(1, "AGENDADO"),
    EM_ANDAMENTO(2, "EM ANDAMENTO"),
    FINALIZADO(3, "FINALIZADO");

    private String descricao;
    private Integer codigo;


    EStatus(Integer codigo, String value) {
        this.codigo = codigo;
        this.descricao = value;
    }

    @JsonValue
    public String getDescricao() {
        return descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }


    @Override
    public String toString() {
        return String.valueOf(descricao);
    }

    @JsonCreator
    public static EStatus fromCodigo(Integer input) {
        for (EStatus b : EStatus.values()) {
            if (b.codigo.equals(input)) {
                return b;
            }
        }
        return null;
    }
}
