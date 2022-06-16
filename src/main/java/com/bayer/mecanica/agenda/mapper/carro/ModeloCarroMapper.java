package com.bayer.mecanica.agenda.mapper.carro;


import com.bayer.mecanica.agenda.domain.ModeloCarro;
import com.bayer.mecanica.agenda.representation.carro.ModeloCarroResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ModeloCarroMapper {

    @Autowired
    MarcaCarroMapper marcaCarroMapper;

    public ModeloCarroResponse toResponse(ModeloCarro domain) {
        return ModeloCarroResponse.builder()
                .id(domain.getId())
                .descricao(domain.getDescricao())
                .marcaCarro(marcaCarroMapper.toResponse(domain.getMarcaCarro()))
                .build();
    }

    public List<ModeloCarroResponse> toResponse(List<ModeloCarro> domain) {
        return domain.stream().map(this::toResponse).collect(Collectors.toList());
    }
}
