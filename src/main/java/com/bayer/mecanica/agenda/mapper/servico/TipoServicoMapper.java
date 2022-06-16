package com.bayer.mecanica.agenda.mapper.servico;

import com.bayer.mecanica.agenda.domain.TipoServico;
import com.bayer.mecanica.agenda.representation.servico.CadastrarTipoServicoRequest;
import com.bayer.mecanica.agenda.representation.servico.TipoServicoResponse;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TipoServicoMapper {

    public TipoServicoResponse toResponse(TipoServico domain) {
        return TipoServicoResponse.builder()
                .id(domain.getId())
                .tempoServico(domain.getTempoServico())
                .descricao(domain.getDescricao())
                .valor(domain.getValor())
                .build();
    }

    public List<TipoServicoResponse> toResponse(List<TipoServico> domain) {
        return domain.stream().map(this::toResponse).collect(Collectors.toList());
    }

    public TipoServico toDomain(CadastrarTipoServicoRequest request) {
        return TipoServico.builder()
                .tempoServico(request.getTempo())
                .descricao(request.getDescricao())
                .valor(request.getValor())
                .build();
    }

    private BigDecimal constroiBigDecimal(Integer valor) {
        return BigDecimal.valueOf(valor);
    }
}
