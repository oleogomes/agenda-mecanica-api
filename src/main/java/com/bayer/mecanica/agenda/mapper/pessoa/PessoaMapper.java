package com.bayer.mecanica.agenda.mapper.pessoa;

import com.bayer.mecanica.agenda.domain.Servico;
import com.bayer.mecanica.agenda.domain.pessoa.ERole;
import com.bayer.mecanica.agenda.domain.pessoa.Pessoa;
import com.bayer.mecanica.agenda.domain.pessoa.Role;
import com.bayer.mecanica.agenda.repository.pessoa.RoleRepository;
import com.bayer.mecanica.agenda.repository.servico.ServicoRepository;
import com.bayer.mecanica.agenda.representation.authorization.request.CadastrarPessoaRequest;
import com.bayer.mecanica.agenda.representation.pessoa.ClienteResponse;
import com.bayer.mecanica.agenda.representation.pessoa.MecanicoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PessoaMapper {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ServicoRepository servicoRepository;

    public Pessoa toDomain(CadastrarPessoaRequest request) {
        Set<Role> roles = new HashSet<>();
        request.getRole().forEach(roleRequest -> {
            Role role = roleRepository.findByName(ERole.valueOf(roleRequest)).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(role);
        });

        return Pessoa.builder()
                .email(request.getEmail())
                .username(request.getUsername())
                .nome(request.getNome())
                .senha(request.getSenha())
                .roles(roles)
                .build();
    }

    public MecanicoResponse toResponseMecanico(Pessoa domain) {
        List<Servico> servicos = servicoRepository.findAllByMecanico(domain).orElse(new ArrayList<>());
        return MecanicoResponse.builder()
                .id(domain.getId())
                .email(domain.getEmail())
                .nome(domain.getNome())
                .servicos(servicos.size())
                .build();
    }

    public List<MecanicoResponse> toResponseMecanico(List<Pessoa> domain) {
        return domain.stream().map(this::toResponseMecanico).collect(Collectors.toList());
    }

    public ClienteResponse toResponseCliente(Pessoa domain) {
        List<Servico> servicos = servicoRepository.findAllByCliente(domain).orElse(new ArrayList<>());
        return ClienteResponse.builder()
                .id(domain.getId())
                .email(domain.getEmail())
                .nome(domain.getNome())
                .servicos(servicos.size())
                .build();
    }

    public List<ClienteResponse> toResponseCliente(List<Pessoa> domain) {
        return domain.stream().map(this::toResponseCliente).collect(Collectors.toList());
    }
}
