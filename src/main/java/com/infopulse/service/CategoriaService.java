package com.infopulse.service;

import com.infopulse.service.dto.CategoriaDTO;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.infopulse.domain.Categoria}.
 */
public interface CategoriaService {
    /**
     * Save a categoria.
     *
     * @param categoriaDTO the entity to save.
     * @return the persisted entity.
     */
    CategoriaDTO save(CategoriaDTO categoriaDTO);

    /**
     * Updates a categoria.
     *
     * @param categoriaDTO the entity to update.
     * @return the persisted entity.
     */
    CategoriaDTO update(CategoriaDTO categoriaDTO);

    /**
     * Partially updates a categoria.
     *
     * @param categoriaDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<CategoriaDTO> partialUpdate(CategoriaDTO categoriaDTO);

    /**
     * Get the "id" categoria.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CategoriaDTO> findOne(Long id);

    /**
     * Delete the "id" categoria.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
