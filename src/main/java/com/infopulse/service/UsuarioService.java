package com.infopulse.service;

import com.infopulse.service.dto.UsuarioDTO;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.infopulse.domain.Usuario}.
 */
public interface UsuarioService {
    /**
     * Save a usuario.
     *
     * @param usuarioDTO the entity to save.
     * @return the persisted entity.
     */
    UsuarioDTO save(UsuarioDTO usuarioDTO);

    /**
     * Updates a usuario.
     *
     * @param usuarioDTO the entity to update.
     * @return the persisted entity.
     */
    UsuarioDTO update(UsuarioDTO usuarioDTO);

    /**
     * Partially updates a usuario.
     *
     * @param usuarioDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<UsuarioDTO> partialUpdate(UsuarioDTO usuarioDTO);

    /**
     * Get the "id" usuario.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<UsuarioDTO> findOne(Long id);

    /**
     * Delete the "id" usuario.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
