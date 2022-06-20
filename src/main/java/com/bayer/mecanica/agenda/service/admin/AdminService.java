package com.bayer.mecanica.agenda.service.admin;

import com.bayer.mecanica.agenda.domain.pessoa.ERole;
import com.bayer.mecanica.agenda.domain.pessoa.Pessoa;
import com.bayer.mecanica.agenda.domain.pessoa.Role;
import com.bayer.mecanica.agenda.mapper.pessoa.PessoaMapper;
import com.bayer.mecanica.agenda.repository.pessoa.PessoaRepository;
import com.bayer.mecanica.agenda.repository.pessoa.RoleRepository;
import com.bayer.mecanica.agenda.representation.pessoa.ClienteResponse;
import com.bayer.mecanica.agenda.representation.pessoa.MecanicoResponse;
import com.bayer.mecanica.agenda.service.pessoa.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AdminService {

    @Autowired
    PessoaMapper pessoaMapper;

    @Autowired
    PessoaService pessoaService;

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    RoleRepository roleRepository;

    public List<MecanicoResponse> getMecanicos() {
        Optional<Role> roleMecanico = roleRepository.findByName(ERole.ROLE_MECANICO);
        Set<Role> roles = new HashSet<>();
        roles.add(roleMecanico.get());
        List<Pessoa> mecanicos = pessoaRepository.getAllByRoles(roles);
        List<MecanicoResponse> response = pessoaMapper.toResponseMecanico(mecanicos);
        return (response);
    }

    public List<ClienteResponse> getClientes() {
        Optional<Role> roleMecanico = roleRepository.findByName(ERole.ROLE_CLIENTE);
        Set<Role> roles = new HashSet<>();
        roles.add(roleMecanico.get());
        List<Pessoa> clientes = pessoaRepository.getAllByRoles(roles);
        List<ClienteResponse> response = pessoaMapper.toResponseCliente(clientes);
        return (response);
    }

}
