package com.infopulse.service;

import com.infopulse.service.dto.VinculoGrupoPermissaoDTO;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.infopulse.domain.VinculoGrupoPermissao}.
 */
public interface VinculoGrupoPermissaoService {
    /**
     * Save a vinculoGrupoPermissao.
     *
     * @param vinculoGrupoPermissaoDTO the entity to save.
     * @return the persisted entity.
     */
    VinculoGrupoPermissaoDTO save(VinculoGrupoPermissaoDTO vinculoGrupoPermissaoDTO);

    /**
     * Updates a vinculoGrupoPermissao.
     *
     * @param vinculoGrupoPermissaoDTO the entity to update.
     * @return the persisted entity.
     */
    VinculoGrupoPermissaoDTO update(VinculoGrupoPermissaoDTO vinculoGrupoPermissaoDTO);

    /**
     * Partially updates a vinculoGrupoPermissao.
     *
     * @param vinculoGrupoPermissaoDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<VinculoGrupoPermissaoDTO> partialUpdate(VinculoGrupoPermissaoDTO vinculoGrupoPermissaoDTO);

    /**
     * Get the "id" vinculoGrupoPermissao.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<VinculoGrupoPermissaoDTO> findOne(Long id);

    /**
     * Delete the "id" vinculoGrupoPermissao.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
