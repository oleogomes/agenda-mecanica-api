package com.bayer.mecanica.agenda.mapper.servico;

import com.bayer.mecanica.agenda.domain.StatusServico;
import com.bayer.mecanica.agenda.representation.servico.StatusServicoResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StatusServicoMapper {

    public StatusServicoResponse toResponse(StatusServico domain) {
        return StatusServicoResponse.builder()
                .id(domain.getId())
                .descricao(domain.getDescricao())
                .build();
    }

    public List<StatusServicoResponse> toResponse(List<StatusServico> domain) {
        return domain.stream().map(this::toResponse).collect(Collectors.toList());
    }
}
