package com.bayer.mecanica.agenda.repository.carro;

import com.bayer.mecanica.agenda.domain.MarcaCarro;
import com.bayer.mecanica.agenda.domain.ModeloCarro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModeloCarroRepository extends JpaRepository<ModeloCarro, Long> {
    List<ModeloCarro> getAllByMarcaCarro(MarcaCarro marcaCarro);
}
