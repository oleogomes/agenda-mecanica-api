package com.bayer.mecanica.agenda.service.servico.servico;

import com.bayer.mecanica.agenda.domain.Carro;
import com.bayer.mecanica.agenda.domain.Servico;
import com.bayer.mecanica.agenda.domain.TipoServico;
import com.bayer.mecanica.agenda.domain.pessoa.Pessoa;
import com.bayer.mecanica.agenda.repository.servico.ServicoRepository;
import com.bayer.mecanica.agenda.representation.authorization.response.MessageResponse;
import com.bayer.mecanica.agenda.representation.servico.AgendarServicoRequest;
import com.bayer.mecanica.agenda.service.carro.CarroService;
import com.bayer.mecanica.agenda.service.pessoa.PessoaService;
import com.bayer.mecanica.agenda.service.servico.tipo.TipoServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {

    @Autowired
    ServicoRepository servicoRepository;

    @Autowired
    CarroService carroService;

    @Autowired
    PessoaService pessoaService;

    @Autowired
    TipoServicoService tipoServicoService;

    public ResponseEntity<?> agendarServico(AgendarServicoRequest request) {
        Pessoa pessoa = pessoaService.getPessoaById(Long.valueOf(request.getIdCliente()));
        Carro carro = carroService.getCarroById(Long.valueOf(request.getIdCarro()));
        TipoServico tipoServico = tipoServicoService.getTipoServicoById(Long.valueOf(request.getIdTipoServico()));

        Servico servico = Servico.builder().
                carro(carro).
                cliente(pessoa).
                tipo(tipoServico).
                dataHora(request.getDatahora()).
                build();

        servicoRepository.save(servico);
        return ResponseEntity.ok(new MessageResponse("Serviço agendado com sucesso!"));
    }
}
