package com.infopulse.repository;

import com.infopulse.domain.GrupoUsuario;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the GrupoUsuario entity.
 */
@SuppressWarnings("unused")
@Repository
public interface GrupoUsuarioRepository extends JpaRepository<GrupoUsuario, Long>, JpaSpecificationExecutor<GrupoUsuario> {}
