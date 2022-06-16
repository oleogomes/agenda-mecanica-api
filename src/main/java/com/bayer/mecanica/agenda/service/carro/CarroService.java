package com.bayer.mecanica.agenda.service.carro;

import com.bayer.mecanica.agenda.domain.Carro;
import com.bayer.mecanica.agenda.domain.pessoa.Pessoa;
import com.bayer.mecanica.agenda.mapper.carro.CarroMapper;
import com.bayer.mecanica.agenda.repository.carro.CarroRepository;
import com.bayer.mecanica.agenda.representation.carro.CadastrarCarroRequest;
import com.bayer.mecanica.agenda.representation.carro.CarroResponse;
import com.bayer.mecanica.agenda.service.pessoa.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CarroService {

    @Autowired
    CarroRepository carroRepository;

    @Autowired
    CarroMapper carroMapper;

    @Autowired
    PessoaService pessoaService;

    public ResponseEntity<?> cadastrarCarro(CadastrarCarroRequest request) {
        Carro carro = carroMapper.toDomain(request);
        carroRepository.save(carro);
        return ResponseEntity.ok("Carro cadastrado com sucesso");
    }

    public List<CarroResponse> getCarrosByPropietario(String idPessoa) {
        Pessoa pessoa = pessoaService.getPessoaById(Long.valueOf(idPessoa));
        List<CarroResponse> carros = new ArrayList<>();
        if(Objects.nonNull(pessoa)) {
            List<Carro> carrosDomain = carroRepository.findAllByProprietario(pessoa);
            carros = carroMapper.toResponse(carrosDomain);
        }
        return carros;

    }
}
