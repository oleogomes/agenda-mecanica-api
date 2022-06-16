package com.bayer.mecanica.agenda.service.pessoa;

import com.bayer.mecanica.agenda.domain.pessoa.Pessoa;
import com.bayer.mecanica.agenda.mapper.pessoa.PessoaMapper;
import com.bayer.mecanica.agenda.repository.pessoa.PessoaRepository;
import com.bayer.mecanica.agenda.repository.pessoa.RoleRepository;
import com.bayer.mecanica.agenda.representation.authorization.request.CadastrarPessoaRequest;
import com.bayer.mecanica.agenda.representation.authorization.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    PessoaMapper pessoaMapper;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    RoleRepository roleRepository;

    public Pessoa getPessoaById(Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.orElse(null);
    }
    public ResponseEntity<?> cadastrarPessoa(CadastrarPessoaRequest request) {
        Pessoa pessoa = pessoaMapper.toDomain(request);
        if (pessoaRepository.existsByEmail(pessoa.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already taken!"));
        }

        if (pessoaRepository.existsByUsername(pessoa.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        pessoa.setSenha(encoder.encode(pessoa.getSenha()));

        pessoaRepository.save(pessoa);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

}
