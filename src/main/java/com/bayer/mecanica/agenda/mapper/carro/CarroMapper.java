package com.bayer.mecanica.agenda.mapper.carro;

import com.bayer.mecanica.agenda.domain.Carro;
import com.bayer.mecanica.agenda.mapper.pessoa.PessoaMapper;
import com.bayer.mecanica.agenda.representation.carro.CadastrarCarroRequest;
import com.bayer.mecanica.agenda.representation.carro.CarroResponse;
import com.bayer.mecanica.agenda.service.carro.ModeloCarroService;
import com.bayer.mecanica.agenda.service.pessoa.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarroMapper {

    @Autowired
    PessoaMapper pessoaMapper;

    @Autowired
    ModeloCarroMapper modeloCarroMapper;

    @Autowired
    ModeloCarroService modeloCarroService;

    @Autowired
    PessoaService pessoaService;

    public CarroResponse toResponse (Carro domain) {
        return CarroResponse.builder()
                .id(domain.getId())
                .anoModelo(domain.getAnoModelo())
                .placa(domain.getPlaca())
                .modelo(domain.getModelo().getDescricao())
                .marca(domain.getModelo().getMarcaCarro().getDescricao())
                .build();
    }

    public List<CarroResponse> toResponse(List<Carro> domain) {
        return domain.stream().map(this::toResponse).collect(Collectors.toList());
    }

    public Carro toDomain(CadastrarCarroRequest request) {
        return Carro.builder()
                .anoModelo(request.getAnoModelo())
                .modelo(modeloCarroService.getModeloCarroById(montaLong(request.getCodigoModeloCarro())))
                .placa(request.getPlaca())
                .proprietario(pessoaService.getPessoaById(montaLong(request.getCodigoProprietario())))
                .build();
    }

    private Long montaLong(String string) {
        return Long.valueOf(string);
    }
}
