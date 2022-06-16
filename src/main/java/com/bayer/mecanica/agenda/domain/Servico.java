package com.bayer.mecanica.agenda.domain;

import com.bayer.mecanica.agenda.domain.pessoa.Pessoa;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "tbservico")
@Inheritance(strategy = InheritanceType.JOINED)

public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_hora")
    @NotNull
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "id_carro")
    @NotNull
    private Carro carro;

    @ManyToOne
    @JoinColumn(name = "id_status_servico")
    private StatusServico status;

    @ManyToOne
    @JoinColumn(name = "id_tipo_servico")
    @NotNull
    private TipoServico tipo;

    @ManyToOne
    @JoinColumn(name = "id_mecanico")
    private Pessoa mecanico;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @NotNull
    private Pessoa cliente;

}

