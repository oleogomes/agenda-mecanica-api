package com.bayer.mecanica.agenda.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "tbmarcacarro")
@Inheritance(strategy = InheritanceType.JOINED)

public class MarcaCarro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String descricao;

    public MarcaCarro(String descricao) {
        this.descricao = descricao;
    }
}
