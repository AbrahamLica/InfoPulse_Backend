package com.infopulse.service;

import com.infopulse.service.dto.GrupoUsuarioDTO;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.infopulse.domain.GrupoUsuario}.
 */
public interface GrupoUsuarioService {
    /**
     * Save a grupoUsuario.
     *
     * @param grupoUsuarioDTO the entity to save.
     * @return the persisted entity.
     */
    GrupoUsuarioDTO save(GrupoUsuarioDTO grupoUsuarioDTO);

    /**
     * Updates a grupoUsuario.
     *
     * @param grupoUsuarioDTO the entity to update.
     * @return the persisted entity.
     */
    GrupoUsuarioDTO update(GrupoUsuarioDTO grupoUsuarioDTO);

    /**
     * Partially updates a grupoUsuario.
     *
     * @param grupoUsuarioDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<GrupoUsuarioDTO> partialUpdate(GrupoUsuarioDTO grupoUsuarioDTO);

    /**
     * Get the "id" grupoUsuario.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<GrupoUsuarioDTO> findOne(Long id);

    /**
     * Delete the "id" grupoUsuario.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
