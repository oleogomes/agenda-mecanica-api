package com.bayer.mecanica.agenda.representation.carro;

import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CadastrarCarroRequest {

    @NotNull
    private String placa;

    @NotNull
    private String anoModelo;

    @NotNull
    private String codigoModeloCarro;

    @NotNull
    private String codigoProprietario;
}
