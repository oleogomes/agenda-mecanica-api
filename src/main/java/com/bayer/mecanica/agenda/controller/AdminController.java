package com.bayer.mecanica.agenda.controller;

import com.bayer.mecanica.agenda.domain.pessoa.Pessoa;
import com.bayer.mecanica.agenda.representation.servico.CadastrarTipoServicoRequest;
import com.bayer.mecanica.agenda.service.admin.AdminService;
import com.bayer.mecanica.agenda.service.servico.tipo.TipoServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    TipoServicoService tipoServicoService;

    @PostMapping("/relatorios/lista-mecanicos")
    public ResponseEntity<List<Pessoa>> getMecanicos() {
        return ResponseEntity.ok(adminService.getMecanicos());
    }

    @PostMapping("/servicos/cadastrar")
    public ResponseEntity<?> cadastrarTipoServico(@Valid @RequestBody CadastrarTipoServicoRequest cadastrarTipoServicoRequest) {
        return (tipoServicoService.cadastrarTipoServico(cadastrarTipoServicoRequest));
    }

}
