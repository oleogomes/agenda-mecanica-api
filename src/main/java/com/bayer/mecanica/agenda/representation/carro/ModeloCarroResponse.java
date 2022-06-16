package com.bayer.mecanica.agenda.representation.carro;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ModeloCarroResponse {

    private Long id;
    private String descricao;
    private MarcaCarroResponse marcaCarro;
}
