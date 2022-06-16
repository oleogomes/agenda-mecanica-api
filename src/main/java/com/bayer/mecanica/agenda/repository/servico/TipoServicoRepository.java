package com.bayer.mecanica.agenda.repository.servico;

import com.bayer.mecanica.agenda.domain.TipoServico;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TipoServicoRepository extends JpaRepository<TipoServico, Long> {
}
