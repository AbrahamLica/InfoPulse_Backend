package com.infopulse.repository;

import com.infopulse.domain.VinculoGrupoPermissao;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the VinculoGrupoPermissao entity.
 */
@SuppressWarnings("unused")
@Repository
public interface VinculoGrupoPermissaoRepository
    extends JpaRepository<VinculoGrupoPermissao, Long>, JpaSpecificationExecutor<VinculoGrupoPermissao> {}
