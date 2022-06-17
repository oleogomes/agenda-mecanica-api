package com.bayer.mecanica.agenda.mapper.servico;

import com.bayer.mecanica.agenda.domain.Servico;
import com.bayer.mecanica.agenda.mapper.carro.CarroMapper;
import com.bayer.mecanica.agenda.mapper.pessoa.PessoaMapper;
import com.bayer.mecanica.agenda.representation.servico.AgendarServicoRequest;
import com.bayer.mecanica.agenda.representation.servico.ServicoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ServicoMapper {

    @Autowired
    CarroMapper carroMapper;

    @Autowired
    PessoaMapper pessoaMapper;

    @Autowired
    TipoServicoMapper tipoServicoMapper;

    @Autowired
    StatusServicoMapper statusServicoMapper;

    public ServicoResponse toResponse(Servico domain) {
        return ServicoResponse.builder()
                .id(domain.getId())
                .carro(carroMapper.toResponse(domain.getCarro()))
                .mecanico(pessoaMapper.toResponseMecanico(domain.getMecanico()))
                .cliente(pessoaMapper.toResponseCliente(domain.getCliente()))
                .tipo(tipoServicoMapper.toResponse(domain.getTipo()))
                .status(statusServicoMapper.toResponse(domain.getStatus()))
                .build();
    }

    public List<ServicoResponse> toResponse(List<Servico> domain) {
        return domain.stream().map(this::toResponse).collect(Collectors.toList());
    }
    
}
