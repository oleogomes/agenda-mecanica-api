package com.bayer.mecanica.agenda.repository.carro;

import com.bayer.mecanica.agenda.domain.MarcaCarro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaCarroRepository extends JpaRepository<MarcaCarro, Long> {
}
