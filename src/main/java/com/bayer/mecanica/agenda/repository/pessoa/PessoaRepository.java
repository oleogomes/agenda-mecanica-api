package com.bayer.mecanica.agenda.repository.pessoa;

import com.bayer.mecanica.agenda.domain.pessoa.Pessoa;
import com.bayer.mecanica.agenda.domain.pessoa.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);
    Optional<Pessoa> findByUsername(String username);
    Optional<List<Pessoa>>findAllByRoles(Set<Role> roles);
    List<Pessoa> getAllByRoles(Set<Role> roles);
}
