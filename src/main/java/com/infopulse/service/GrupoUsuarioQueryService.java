package com.infopulse.service;

import com.infopulse.domain.*; // for static metamodels
import com.infopulse.domain.GrupoUsuario;
import com.infopulse.repository.GrupoUsuarioRepository;
import com.infopulse.service.criteria.GrupoUsuarioCriteria;
import com.infopulse.service.dto.GrupoUsuarioDTO;
import com.infopulse.service.mapper.GrupoUsuarioMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link GrupoUsuario} entities in the database.
 * The main input is a {@link GrupoUsuarioCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link Page} of {@link GrupoUsuarioDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class GrupoUsuarioQueryService extends QueryService<GrupoUsuario> {

    private static final Logger log = LoggerFactory.getLogger(GrupoUsuarioQueryService.class);

    private final GrupoUsuarioRepository grupoUsuarioRepository;

    private final GrupoUsuarioMapper grupoUsuarioMapper;

    public GrupoUsuarioQueryService(GrupoUsuarioRepository grupoUsuarioRepository, GrupoUsuarioMapper grupoUsuarioMapper) {
        this.grupoUsuarioRepository = grupoUsuarioRepository;
        this.grupoUsuarioMapper = grupoUsuarioMapper;
    }

    /**
     * Return a {@link Page} of {@link GrupoUsuarioDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<GrupoUsuarioDTO> findByCriteria(GrupoUsuarioCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<GrupoUsuario> specification = createSpecification(criteria);
        return grupoUsuarioRepository.findAll(specification, page).map(grupoUsuarioMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(GrupoUsuarioCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<GrupoUsuario> specification = createSpecification(criteria);
        return grupoUsuarioRepository.count(specification);
    }

    /**
     * Function to convert {@link GrupoUsuarioCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<GrupoUsuario> createSpecification(GrupoUsuarioCriteria criteria) {
        Specification<GrupoUsuario> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), GrupoUsuario_.id));
            }
            if (criteria.getNome() != null) {
                specification = specification.and(buildStringSpecification(criteria.getNome(), GrupoUsuario_.nome));
            }
            if (criteria.getDescricao() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDescricao(), GrupoUsuario_.descricao));
            }
        }
        return specification;
    }
}
