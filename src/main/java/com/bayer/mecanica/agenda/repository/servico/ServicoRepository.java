package com.bayer.mecanica.agenda.repository.servico;

import com.bayer.mecanica.agenda.domain.Servico;
import com.bayer.mecanica.agenda.domain.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

    Optional<List<Servico>> findAllByMecanico(Pessoa mecanico);
    Optional<List<Servico>> findAllByCliente(Pessoa cliente);

}
