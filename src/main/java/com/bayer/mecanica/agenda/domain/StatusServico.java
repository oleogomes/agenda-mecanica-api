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
@Table(name = "tbstatusservico")
@Inheritance(strategy = InheritanceType.JOINED)
public class StatusServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String descricao;

    public StatusServico(String descricao) {
        this.descricao = descricao;
    }
}