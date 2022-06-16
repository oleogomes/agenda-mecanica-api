package com.bayer.mecanica.agenda.domain;

import com.bayer.mecanica.agenda.domain.pessoa.Pessoa;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Setter
@Table(name = "tbcarro", uniqueConstraints = {
        @UniqueConstraint(columnNames = "placa")
})
@Inheritance(strategy = InheritanceType.JOINED)
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String placa;

    @NotNull
    private String anoModelo;

    @ManyToOne
    @JoinColumn(name = "id_modelo")
    @NotNull
    private ModeloCarro modelo;

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    @NotNull
    private Pessoa proprietario;

    public Carro(String placa, String anoModelo, ModeloCarro modelo, Pessoa proprietario) {
        this.placa = placa;
        this.anoModelo = anoModelo;
        this.modelo = modelo;
        this.proprietario = proprietario;
    }
}
