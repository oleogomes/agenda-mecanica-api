package com.bayer.mecanica.agenda.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "tbtiposervico")
@Inheritance(strategy = InheritanceType.JOINED)
public class TipoServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String descricao;

    @NotNull
    private Integer tempoServico;

    @NotNull
    private Integer valor;

    public TipoServico(String descricao, Integer tempoServico, Integer valor) {
        this.descricao = descricao;
        this.tempoServico = tempoServico;
        this.valor = valor;
    }
}