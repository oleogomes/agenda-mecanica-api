package com.bayer.mecanica.agenda.controller;

import com.bayer.mecanica.agenda.representation.carro.CadastrarCarroRequest;
import com.bayer.mecanica.agenda.representation.servico.AgendarServicoRequest;
import com.bayer.mecanica.agenda.service.carro.CarroService;
import com.bayer.mecanica.agenda.service.pessoa.PessoaService;
import com.bayer.mecanica.agenda.service.servico.servico.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/cliente")
@PreAuthorize("hasRole('ROLE_CLIENTE')")
public class ClienteController {

    @Autowired
    CarroService carroService;

    @Autowired
    ServicoService servicoService;


    @PostMapping("/carros/cadastrar")
    public ResponseEntity<?> cadastrarCarro(@Valid @RequestBody CadastrarCarroRequest cadastrarCarroRequest) {
        return (carroService.cadastrarCarro(cadastrarCarroRequest));
    }

    @PostMapping("/servicos/agendar")
    public ResponseEntity<?> agendarServico(@Valid @RequestBody AgendarServicoRequest agendarServicoRequest) {
       return servicoService.agendarServico(agendarServicoRequest);
    }

}
