package com.bayer.mecanica.agenda.controller;

import com.bayer.mecanica.agenda.service.servico.tipo.TipoServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/servico")
@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MECANICO', 'ROLE_CLIENTE')")
public class ServicoController {

    @Autowired
    TipoServicoService tipoServicoService;

    @PostMapping("/tipos")
    public ResponseEntity<?> getTiposServico() {
        return ResponseEntity.ok(tipoServicoService.getTiposServico());
    }
}
