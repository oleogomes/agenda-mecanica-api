package com.bayer.mecanica.agenda.repository.carro;

import com.bayer.mecanica.agenda.domain.Carro;
import com.bayer.mecanica.agenda.domain.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {

    List<Carro> findAllByProprietario(Pessoa proprietario);
}
