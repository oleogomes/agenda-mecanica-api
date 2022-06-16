package com.bayer.mecanica.agenda.service.carro;

import com.bayer.mecanica.agenda.domain.Carro;
import com.bayer.mecanica.agenda.mapper.carro.CarroMapper;
import com.bayer.mecanica.agenda.repository.carro.CarroRepository;
import com.bayer.mecanica.agenda.representation.carro.CadastrarCarroRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CarroService {

    @Autowired
    CarroRepository carroRepository;

    @Autowired
    CarroMapper carroMapper;

    public ResponseEntity<?> cadastrarCarro(CadastrarCarroRequest request) {
        Carro carro = carroMapper.toDomain(request);
        carroRepository.save(carro);
        return ResponseEntity.ok("Carro cadastrado com sucesso");
    }
}
