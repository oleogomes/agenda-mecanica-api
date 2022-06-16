package com.bayer.mecanica.agenda.representation.servico;

import com.bayer.mecanica.agenda.representation.carro.CarroResponse;
import com.bayer.mecanica.agenda.representation.pessoa.ClienteResponse;
import com.bayer.mecanica.agenda.representation.pessoa.MecanicoResponse;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServicoResponse {
    private Long id;
    private LocalDateTime dataHora;
    private CarroResponse carro;
    private StatusServicoResponse status;
    private TipoServicoResponse tipo;
    private MecanicoResponse mecanico;
    private ClienteResponse cliente;
}
