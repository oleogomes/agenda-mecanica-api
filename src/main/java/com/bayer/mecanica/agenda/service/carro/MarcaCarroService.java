package com.bayer.mecanica.agenda.service.carro;

import com.bayer.mecanica.agenda.domain.MarcaCarro;
import com.bayer.mecanica.agenda.repository.carro.MarcaCarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaCarroService {

    @Autowired
    MarcaCarroRepository marcaCarroRepository;

    public List<MarcaCarro> getAll() {
        return marcaCarroRepository.findAll(Sort.by("descricao"));
    }
}
