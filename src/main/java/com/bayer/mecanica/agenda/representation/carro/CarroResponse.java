package com.bayer.mecanica.agenda.representation.carro;

import com.bayer.mecanica.agenda.representation.pessoa.ClienteResponse;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarroResponse {

    private Long id;
    private String modelo;
    private String anoModelo;
    private String marca;
    private String placa;
}
