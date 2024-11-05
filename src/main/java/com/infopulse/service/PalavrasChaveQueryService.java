package com.infopulse.service;

import com.infopulse.domain.*; // for static metamodels
import com.infopulse.domain.PalavrasChave;
import com.infopulse.repository.PalavrasChaveRepository;
import com.infopulse.service.criteria.PalavrasChaveCriteria;
import com.infopulse.service.dto.PalavrasChaveDTO;
import com.infopulse.service.mapper.PalavrasChaveMapper;
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
 * Service for executing complex queries for {@link PalavrasChave} entities in the database.
 * The main input is a {@link PalavrasChaveCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link Page} of {@link PalavrasChaveDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class PalavrasChaveQueryService extends QueryService<PalavrasChave> {

    private static final Logger log = LoggerFactory.getLogger(PalavrasChaveQueryService.class);

    private final PalavrasChaveRepository palavrasChaveRepository;

    private final PalavrasChaveMapper palavrasChaveMapper;

    public PalavrasChaveQueryService(PalavrasChaveRepository palavrasChaveRepository, PalavrasChaveMapper palavrasChaveMapper) {
        this.palavrasChaveRepository = palavrasChaveRepository;
        this.palavrasChaveMapper = palavrasChaveMapper;
    }

    /**
     * Return a {@link Page} of {@link PalavrasChaveDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<PalavrasChaveDTO> findByCriteria(PalavrasChaveCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<PalavrasChave> specification = createSpecification(criteria);
        return palavrasChaveRepository.findAll(specification, page).map(palavrasChaveMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(PalavrasChaveCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<PalavrasChave> specification = createSpecification(criteria);
        return palavrasChaveRepository.count(specification);
    }

    /**
     * Function to convert {@link PalavrasChaveCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<PalavrasChave> createSpecification(PalavrasChaveCriteria criteria) {
        Specification<PalavrasChave> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), PalavrasChave_.id));
            }
            if (criteria.getPalavra() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPalavra(), PalavrasChave_.palavra));
            }
            if (criteria.getNoticiaId() != null) {
                specification = specification.and(
                    buildSpecification(criteria.getNoticiaId(), root -> root.join(PalavrasChave_.noticia, JoinType.LEFT).get(Noticia_.id))
                );
            }
        }
        return specification;
    }
}
