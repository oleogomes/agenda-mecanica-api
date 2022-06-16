package com.bayer.mecanica.agenda.service.carro;

import com.bayer.mecanica.agenda.domain.MarcaCarro;
import com.bayer.mecanica.agenda.domain.ModeloCarro;
import com.bayer.mecanica.agenda.repository.carro.MarcaCarroRepository;
import com.bayer.mecanica.agenda.repository.carro.ModeloCarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModeloCarroService {

    @Autowired
    ModeloCarroRepository modeloCarroRepository;

    @Autowired
    MarcaCarroRepository marcaCarroRepository;

    public List<ModeloCarro> getModelosByMarcaCarro(String idMarcaCarro) {
        Optional<MarcaCarro> marca = marcaCarroRepository.findById(Long.valueOf(idMarcaCarro));
        return modeloCarroRepository.getAllByMarcaCarro(marca.get());
    }

    public ModeloCarro getModeloCarroById(Long id) {
        Optional<ModeloCarro> modeloCarro = modeloCarroRepository.findById(id);
        return modeloCarro.orElse(null);
    }
}
