package com.bayer.mecanica.agenda.representation.carro;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MarcaCarroResponse {
    private Long id;
    private String descricao;
}
