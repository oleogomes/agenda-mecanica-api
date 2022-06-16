package com.bayer.mecanica.agenda.controller;

import com.bayer.mecanica.agenda.mapper.carro.MarcaCarroMapper;
import com.bayer.mecanica.agenda.mapper.carro.ModeloCarroMapper;
import com.bayer.mecanica.agenda.representation.carro.MarcaCarroResponse;
import com.bayer.mecanica.agenda.representation.carro.ModeloCarroResponse;
import com.bayer.mecanica.agenda.service.carro.MarcaCarroService;
import com.bayer.mecanica.agenda.service.carro.ModeloCarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    ModeloCarroService modeloCarroService;

    @Autowired
    MarcaCarroService marcaCarroService;

    @Autowired
    ModeloCarroMapper modeloCarroMapper;

    @Autowired
    MarcaCarroMapper marcaCarroMapper;

    @PostMapping("/marca/get-marcas")
    @ResponseStatus(HttpStatus.CREATED)
    public List<MarcaCarroResponse> getMarcas() {
        return marcaCarroMapper.toResponse(marcaCarroService.getAll());
    }

    @PostMapping("/modelo/get-by-marca")
    @ResponseStatus(HttpStatus.CREATED)
    public List<ModeloCarroResponse> getModelosByMarca(@RequestParam String idMarca) {
        return modeloCarroMapper.toResponse(modeloCarroService.getModelosByMarcaCarro(idMarca));
    }
}
