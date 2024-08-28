package com.infopulse.service;

import com.infopulse.domain.*; // for static metamodels
import com.infopulse.domain.Noticia;
import com.infopulse.repository.NoticiaRepository;
import com.infopulse.service.criteria.NoticiaCriteria;
import com.infopulse.service.dto.NoticiaDTO;
import com.infopulse.service.mapper.NoticiaMapper;
import jakarta.persistence.criteria.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link Noticia} entities in the database.
 * The main input is a {@link NoticiaCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link Page} of {@link NoticiaDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class NoticiaQueryService extends QueryService<Noticia> {

    private static final Logger log = LoggerFactory.getLogger(NoticiaQueryService.class);

    private final NoticiaRepository noticiaRepository;

    private final NoticiaMapper noticiaMapper;

    public NoticiaQueryService(NoticiaRepository noticiaRepository, NoticiaMapper noticiaMapper) {
        this.noticiaRepository = noticiaRepository;
        this.noticiaMapper = noticiaMapper;
    }

    /**
     * Return a {@link Page} of {@link NoticiaDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<NoticiaDTO> findByCriteria(NoticiaCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Noticia> specification = createSpecification(criteria);
        return noticiaRepository.findAll(specification, page).map(noticiaMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(NoticiaCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Noticia> specification = createSpecification(criteria);
        return noticiaRepository.count(specification);
    }

    /**
     * Function to convert {@link NoticiaCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Noticia> createSpecification(NoticiaCriteria criteria) {
        Specification<Noticia> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Noticia_.id));
            }
            if (criteria.getTitulo() != null) {
                specification = specification.and(buildStringSpecification(criteria.getTitulo(), Noticia_.titulo));
            }
            if (criteria.getDataPublicacao() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getDataPublicacao(), Noticia_.dataPublicacao));
            }
            if (criteria.getAutor() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAutor(), Noticia_.autor));
            }
            if (criteria.getAtivo() != null) {
                specification = specification.and(buildSpecification(criteria.getAtivo(), Noticia_.ativo));
            }
            if (criteria.getCategoriaId() != null) {
                specification = specification.and(
                    buildSpecification(criteria.getCategoriaId(), root -> root.join(Noticia_.categoria, JoinType.LEFT).get(Categoria_.id))
                );
            }
            if (criteria.getAutorId() != null) {
                specification = specification.and(
                    buildSpecification(criteria.getAutorId(), root -> root.join(Noticia_.autors, JoinType.LEFT).get(Usuario_.id))
                );
            }
        }
        return specification;
    }
}
