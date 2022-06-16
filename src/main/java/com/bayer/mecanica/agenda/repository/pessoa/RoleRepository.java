package com.bayer.mecanica.agenda.repository.pessoa;

import com.bayer.mecanica.agenda.domain.pessoa.ERole;
import com.bayer.mecanica.agenda.domain.pessoa.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
