package com.bayer.mecanica.agenda.controller;

import com.bayer.mecanica.agenda.domain.Servico;
import com.bayer.mecanica.agenda.mapper.servico.ServicoMapper;
import com.bayer.mecanica.agenda.representation.authorization.response.MessageResponse;
import com.bayer.mecanica.agenda.representation.servico.AtualizarServicoRequest;
import com.bayer.mecanica.agenda.representation.servico.ServicoResponse;
import com.bayer.mecanica.agenda.service.servico.servico.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        return ResponseEntity.ok(servicoMapper.toResponse(servicoService.getServicosDia()));
    }

    @PostMapping("servico/iniciar")
    public ResponseEntity<?> iniciarServico(@Valid @RequestBody AtualizarServicoRequest request) {
        servicoService.iniciarServico(request);
        return ResponseEntity.ok(new MessageResponse("Servico iniciado com sucesso"));
    }

    @PostMapping("servico/finalizar")
    public ResponseEntity<?> finalizarServico(@Valid @RequestBody AtualizarServicoRequest request) {
        servicoService.finalizarServico(request);
        return ResponseEntity.ok(new MessageResponse("Servico finalizado com sucesso"));
    }
}
