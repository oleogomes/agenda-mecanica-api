package com.bayer.mecanica.agenda.representation.servico;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Builder
@Data
public class AgendarServicoRequest {

    @NotNull
    private String idCarro;

    @NotNull
    private String idCliente;

    @NotNull
    private LocalDateTime datahora;

    @NotNull
    private String idTipoServico;
}
