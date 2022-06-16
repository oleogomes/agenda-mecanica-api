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
    private ModeloCarroResponse modelo;
    private String anoModelo;
    private String placa;
    private ClienteResponse proprietario;
}
