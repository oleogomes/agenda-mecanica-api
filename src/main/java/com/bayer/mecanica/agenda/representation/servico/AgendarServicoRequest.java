package com.bayer.mecanica.agenda.representation.servico;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Builder
@Data
public class AgendarServicoRequest {

    @NotNull
    private String idCarro;

    @NotNull
    private String idCliente;

    @NotNull
    private String dataHora;

    @NotNull
    private String idTipoServico;
}
