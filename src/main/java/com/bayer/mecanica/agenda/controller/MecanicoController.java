package com.bayer.mecanica.agenda.controller;

import com.bayer.mecanica.agenda.mapper.servico.ServicoMapper;
import com.bayer.mecanica.agenda.representation.servico.ServicoResponse;
import com.bayer.mecanica.agenda.service.servico.servico.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/mecanico")
@PreAuthorize("hasRole('ROLE_MECANICO')")
public class MecanicoController {

    @Autowired
    ServicoService servicoService;

    @Autowired
    ServicoMapper servicoMapper;

    @PostMapping("/agenda")
    public ResponseEntity<List<ServicoResponse>> getAgendaDia() {
        return ResponseEntity.ok(servicoMapper.toResponse(servicoService.getServicosByData(LocalDate.now())));
    }
}
