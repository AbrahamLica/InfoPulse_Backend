package com.infopulse.service;

import com.infopulse.domain.*; // for static metamodels
import com.infopulse.domain.Permissao;
import com.infopulse.repository.PermissaoRepository;
import com.infopulse.service.criteria.PermissaoCriteria;
import com.infopulse.service.dto.PermissaoDTO;
import com.infopulse.service.mapper.PermissaoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link Permissao} entities in the database.
 * The main input is a {@link PermissaoCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link Page} of {@link PermissaoDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class PermissaoQueryService extends QueryService<Permissao> {

    private static final Logger log = LoggerFactory.getLogger(PermissaoQueryService.class);

    private final PermissaoRepository permissaoRepository;

    private final PermissaoMapper permissaoMapper;

    public PermissaoQueryService(PermissaoRepository permissaoRepository, PermissaoMapper permissaoMapper) {
        this.permissaoRepository = permissaoRepository;
        this.permissaoMapper = permissaoMapper;
    }

    /**
     * Return a {@link Page} of {@link PermissaoDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<PermissaoDTO> findByCriteria(PermissaoCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Permissao> specification = createSpecification(criteria);
        return permissaoRepository.findAll(specification, page).map(permissaoMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(PermissaoCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Permissao> specification = createSpecification(criteria);
        return permissaoRepository.count(specification);
    }

    /**
     * Function to convert {@link PermissaoCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Permissao> createSpecification(PermissaoCriteria criteria) {
        Specification<Permissao> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Permissao_.id));
            }
            if (criteria.getNome() != null) {
                specification = specification.and(buildStringSpecification(criteria.getNome(), Permissao_.nome));
            }
            if (criteria.getDescricao() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDescricao(), Permissao_.descricao));
            }
        }
        return specification;
    }
}
