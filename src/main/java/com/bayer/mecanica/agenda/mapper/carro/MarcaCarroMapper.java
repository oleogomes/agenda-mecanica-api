package com.bayer.mecanica.agenda.mapper.carro;

import com.bayer.mecanica.agenda.domain.MarcaCarro;
import com.bayer.mecanica.agenda.representation.carro.MarcaCarroResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MarcaCarroMapper {

    public MarcaCarroResponse toResponse (MarcaCarro domain) {
        return MarcaCarroResponse.builder()
                .id(domain.getId())
                .descricao(domain.getDescricao())
                .build();
    }

    public List<MarcaCarroResponse> toResponse(List<MarcaCarro> domain) {
        return domain.stream().map(this::toResponse).collect(Collectors.toList());
    }
}
