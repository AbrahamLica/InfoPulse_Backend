package com.infopulse.repository;

import com.infopulse.domain.GrupoUsuario;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;

public interface GrupoUsuarioRepositoryWithBagRelationships {
    Optional<GrupoUsuario> fetchBagRelationships(Optional<GrupoUsuario> grupoUsuario);

    List<GrupoUsuario> fetchBagRelationships(List<GrupoUsuario> grupoUsuarios);

    Page<GrupoUsuario> fetchBagRelationships(Page<GrupoUsuario> grupoUsuarios);
}
