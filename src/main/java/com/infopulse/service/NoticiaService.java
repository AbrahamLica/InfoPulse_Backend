package com.infopulse.service;

import com.infopulse.service.dto.NoticiaDTO;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.infopulse.domain.Noticia}.
 */
public interface NoticiaService {
    /**
     * Save a noticia.
     *
     * @param noticiaDTO the entity to save.
     * @return the persisted entity.
     */
    NoticiaDTO save(NoticiaDTO noticiaDTO);

    /**
     * Updates a noticia.
     *
     * @param noticiaDTO the entity to update.
     * @return the persisted entity.
     */
    NoticiaDTO update(NoticiaDTO noticiaDTO);

    /**
     * Partially updates a noticia.
     *
     * @param noticiaDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<NoticiaDTO> partialUpdate(NoticiaDTO noticiaDTO);

    /**
     * Get the "id" noticia.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<NoticiaDTO> findOne(Long id);

    /**
     * Delete the "id" noticia.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
