package com.bayer.mecanica.agenda.representation.servico;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoServicoResponse {
    private Long id;
    private String descricao;
    private Integer tempoServico;
    private Integer valor;
}
