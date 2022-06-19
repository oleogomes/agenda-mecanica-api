package com.bayer.mecanica.agenda.representation.servico;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Builder
@Data
public class AtualizarServicoRequest {
    @NotNull
    private Integer idServico;

    @NotNull
    private Integer idMecanico;
}
