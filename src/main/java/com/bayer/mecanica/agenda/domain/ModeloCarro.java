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
@Table(name = "tbmodelocarro")
@Inheritance(strategy = InheritanceType.JOINED)
public class ModeloCarro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_marca")
    @NotNull
    private MarcaCarro marcaCarro;

    public ModeloCarro(String descricao, MarcaCarro marcaCarro) {
        this.descricao = descricao;
        this.marcaCarro = marcaCarro;
    }
}
