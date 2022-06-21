package com.bayer.mecanica.agenda.service.servico.servico;

import com.bayer.mecanica.agenda.domain.Carro;
import com.bayer.mecanica.agenda.domain.EStatus;
import com.bayer.mecanica.agenda.domain.Servico;
import com.bayer.mecanica.agenda.domain.TipoServico;
import com.bayer.mecanica.agenda.domain.pessoa.Pessoa;
import com.bayer.mecanica.agenda.repository.servico.ServicoRepository;
import com.bayer.mecanica.agenda.repository.servico.StatusServicoRepository;
import com.bayer.mecanica.agenda.representation.authorization.response.MessageResponse;
import com.bayer.mecanica.agenda.representation.servico.AgendarServicoRequest;
import com.bayer.mecanica.agenda.representation.servico.AtualizarServicoRequest;
import com.bayer.mecanica.agenda.representation.servico.ServicoResponse;
import com.bayer.mecanica.agenda.service.carro.CarroService;
import com.bayer.mecanica.agenda.service.pessoa.PessoaService;
import com.bayer.mecanica.agenda.service.servico.tipo.TipoServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    StatusServicoRepository statusServicoRepository;

    public ResponseEntity<?> agendarServico(AgendarServicoRequest request) {
        Pessoa pessoa = pessoaService.getPessoaById(Long.valueOf(request.getIdCliente()));
        Carro carro = carroService.getCarroById(Long.valueOf(request.getIdCarro()));
        TipoServico tipoServico = tipoServicoService.getTipoServicoById(Long.valueOf(request.getIdTipoServico()));

        Servico servico = Servico.builder().
                carro(carro).
                cliente(pessoa).
                tipo(tipoServico).
                dataHora(montaDataHora(request.getDataHora())).
                status(statusServicoRepository.findById(EStatus.AGENDADO.getCodigo().longValue()).get()).
                build();

        servicoRepository.save(servico);
        return ResponseEntity.ok(new MessageResponse("Serviço agendado com sucesso!"));
    }

    public List<Servico> getServicosByCliente(String idCliente) {
        Pessoa cliente = pessoaService.getPessoaById(Long.valueOf(idCliente));
        List<Servico> servicos = servicoRepository.findAllByCliente(cliente).get();
        return servicos;
    }

    public List<Servico> getServicosDia() {
        List<Servico> servicos = this.servicoRepository.findAll();
        List<Servico> servicosDia = servicos.stream().
                filter(servico -> servico.getDataHora().toLocalDate().isEqual(LocalDate.now()) ).
                collect(Collectors.toList());
        return servicosDia;
    }

    public List<Servico> getServicos() {
        List<Servico> servicos = this.servicoRepository.findAll();
        return servicos;
    }

    public AtualizarServicoRequest iniciarServico(AtualizarServicoRequest request) {
        Servico servico = servicoRepository.findById(request.getIdServico().longValue()).get();
        Pessoa mecanico = pessoaService.getPessoaById(request.getIdMecanico().longValue());

        servico.setMecanico(mecanico);
        servico.setStatus(statusServicoRepository.findById(EStatus.EM_ANDAMENTO.getCodigo().longValue()).get());

        servicoRepository.save(servico);
        return request;
    }

    public AtualizarServicoRequest finalizarServico(AtualizarServicoRequest request) {
        Servico servico = servicoRepository.findById(request.getIdServico().longValue()).get();
        Pessoa mecanico = pessoaService.getPessoaById(request.getIdMecanico().longValue());

        servico.setMecanico(mecanico);
        servico.setStatus(statusServicoRepository.findById(EStatus.FINALIZADO.getCodigo().longValue()).get());

        servicoRepository.save(servico);
        return request;
    }

    private LocalDateTime montaDataHora(String dataHora) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(dataHora, formatter);
    }
}
