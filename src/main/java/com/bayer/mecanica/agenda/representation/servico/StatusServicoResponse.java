package com.bayer.mecanica.agenda.representation.servico;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatusServicoResponse {

    private Long id;
    private String descricao;
}
