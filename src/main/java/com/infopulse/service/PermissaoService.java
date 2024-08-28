package com.infopulse.service;

import com.infopulse.service.dto.PermissaoDTO;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.infopulse.domain.Permissao}.
 */
public interface PermissaoService {
    /**
     * Save a permissao.
     *
     * @param permissaoDTO the entity to save.
     * @return the persisted entity.
     */
    PermissaoDTO save(PermissaoDTO permissaoDTO);

    /**
     * Updates a permissao.
     *
     * @param permissaoDTO the entity to update.
     * @return the persisted entity.
     */
    PermissaoDTO update(PermissaoDTO permissaoDTO);

    /**
     * Partially updates a permissao.
     *
     * @param permissaoDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<PermissaoDTO> partialUpdate(PermissaoDTO permissaoDTO);

    /**
     * Get the "id" permissao.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PermissaoDTO> findOne(Long id);

    /**
     * Delete the "id" permissao.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
