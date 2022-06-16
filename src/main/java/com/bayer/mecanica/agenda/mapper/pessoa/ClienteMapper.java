package com.bayer.mecanica.agenda.mapper.pessoa;

import com.bayer.mecanica.agenda.domain.pessoa.Pessoa;
import com.bayer.mecanica.agenda.representation.pessoa.ClienteResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteMapper {

//    public Pessoa toDomain(CadastrarPessoaRequest request) {
//        return Pessoa.builder()
//                .email(request.getEmail())
//                .nome(request.getNome() + " " + request.getSobrenome())
//                .senha(request.getSenha())
//                .build();
//    }

    public ClienteResponse toResponse(Pessoa domain) {
        return ClienteResponse.builder()
                .id(domain.getId())
                .email(domain.getEmail())
                .nome(domain.getNome())
                .build();
    }

    public List<ClienteResponse> toResponse(List<Pessoa> domain) {
        return domain.stream().map(this::toResponse).collect(Collectors.toList());
    }
}
