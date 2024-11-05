package com.infopulse.service;

import com.infopulse.service.dto.PalavrasChaveDTO;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.infopulse.domain.PalavrasChave}.
 */
public interface PalavrasChaveService {
    /**
     * Save a palavrasChave.
     *
     * @param palavrasChaveDTO the entity to save.
     * @return the persisted entity.
     */
    PalavrasChaveDTO save(PalavrasChaveDTO palavrasChaveDTO);

    /**
     * Updates a palavrasChave.
     *
     * @param palavrasChaveDTO the entity to update.
     * @return the persisted entity.
     */
    PalavrasChaveDTO update(PalavrasChaveDTO palavrasChaveDTO);

    /**
     * Partially updates a palavrasChave.
     *
     * @param palavrasChaveDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<PalavrasChaveDTO> partialUpdate(PalavrasChaveDTO palavrasChaveDTO);

    /**
     * Get the "id" palavrasChave.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PalavrasChaveDTO> findOne(Long id);

    /**
     * Delete the "id" palavrasChave.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
