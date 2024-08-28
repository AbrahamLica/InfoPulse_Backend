package com.infopulse.service;

import com.infopulse.domain.*; // for static metamodels
import com.infopulse.domain.VinculoGrupoPermissao;
import com.infopulse.repository.VinculoGrupoPermissaoRepository;
import com.infopulse.service.criteria.VinculoGrupoPermissaoCriteria;
import com.infopulse.service.dto.VinculoGrupoPermissaoDTO;
import com.infopulse.service.mapper.VinculoGrupoPermissaoMapper;
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
 * Service for executing complex queries for {@link VinculoGrupoPermissao} entities in the database.
 * The main input is a {@link VinculoGrupoPermissaoCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link Page} of {@link VinculoGrupoPermissaoDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class VinculoGrupoPermissaoQueryService extends QueryService<VinculoGrupoPermissao> {

    private static final Logger log = LoggerFactory.getLogger(VinculoGrupoPermissaoQueryService.class);

    private final VinculoGrupoPermissaoRepository vinculoGrupoPermissaoRepository;

    private final VinculoGrupoPermissaoMapper vinculoGrupoPermissaoMapper;

    public VinculoGrupoPermissaoQueryService(
        VinculoGrupoPermissaoRepository vinculoGrupoPermissaoRepository,
        VinculoGrupoPermissaoMapper vinculoGrupoPermissaoMapper
    ) {
        this.vinculoGrupoPermissaoRepository = vinculoGrupoPermissaoRepository;
        this.vinculoGrupoPermissaoMapper = vinculoGrupoPermissaoMapper;
    }

    /**
     * Return a {@link Page} of {@link VinculoGrupoPermissaoDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<VinculoGrupoPermissaoDTO> findByCriteria(VinculoGrupoPermissaoCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<VinculoGrupoPermissao> specification = createSpecification(criteria);
        return vinculoGrupoPermissaoRepository.findAll(specification, page).map(vinculoGrupoPermissaoMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(VinculoGrupoPermissaoCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<VinculoGrupoPermissao> specification = createSpecification(criteria);
        return vinculoGrupoPermissaoRepository.count(specification);
    }

    /**
     * Function to convert {@link VinculoGrupoPermissaoCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<VinculoGrupoPermissao> createSpecification(VinculoGrupoPermissaoCriteria criteria) {
        Specification<VinculoGrupoPermissao> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), VinculoGrupoPermissao_.id));
            }
            if (criteria.getAtivado() != null) {
                specification = specification.and(buildSpecification(criteria.getAtivado(), VinculoGrupoPermissao_.ativado));
            }
            if (criteria.getGrupoUsuarioId() != null) {
                specification = specification.and(
                    buildSpecification(
                        criteria.getGrupoUsuarioId(),
                        root -> root.join(VinculoGrupoPermissao_.grupoUsuario, JoinType.LEFT).get(GrupoUsuario_.id)
                    )
                );
            }
            if (criteria.getPermissaoId() != null) {
                specification = specification.and(
                    buildSpecification(
                        criteria.getPermissaoId(),
                        root -> root.join(VinculoGrupoPermissao_.permissao, JoinType.LEFT).get(Permissao_.id)
                    )
                );
            }
        }
        return specification;
    }
}
