package com.bayer.mecanica.agenda.controller;

import com.bayer.mecanica.agenda.representation.servico.AgendarServicoRequest;
import com.bayer.mecanica.agenda.service.servico.servico.ServicoService;
import com.bayer.mecanica.agenda.service.servico.tipo.TipoServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/admin")
@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MECANICO', 'ROLE_CLIENTE')")
public class ServicoController {

    @Autowired
    TipoServicoService tipoServicoService;

    @PostMapping("/servicos/tipos")
    public ResponseEntity<?> getTiposServico() {
        return ResponseEntity.ok(tipoServicoService.getTiposServico());
    }
}
