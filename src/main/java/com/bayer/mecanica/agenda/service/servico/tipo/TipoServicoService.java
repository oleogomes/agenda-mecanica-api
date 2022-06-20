package com.bayer.mecanica.agenda.service.servico.tipo;

import com.bayer.mecanica.agenda.domain.TipoServico;
import com.bayer.mecanica.agenda.mapper.servico.TipoServicoMapper;
import com.bayer.mecanica.agenda.repository.servico.TipoServicoRepository;
import com.bayer.mecanica.agenda.representation.authorization.response.MessageResponse;
import com.bayer.mecanica.agenda.representation.servico.CadastrarTipoServicoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoServicoService {

    @Autowired
    TipoServicoRepository repository;

    @Autowired
    TipoServicoMapper tipoServicoMapper;

    public ResponseEntity<?> cadastrarTipoServico(CadastrarTipoServicoRequest request) {
        TipoServico tipoServico = tipoServicoMapper.toDomain(request);

        repository.save(tipoServico);
        return ResponseEntity.ok(new MessageResponse("Serviço cadastrado com sucesso"));
    }

    public TipoServico getTipoServicoById(Long idTipoServico) {
        return repository.findById(idTipoServico).get();
    }

    public List<TipoServico> getTiposServico() {
        return repository.findAll();
    }
}
