package com.bayer.mecanica.agenda.repository.servico;

import com.bayer.mecanica.agenda.domain.StatusServico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusServicoRepository extends JpaRepository<StatusServico, Long> {
}
