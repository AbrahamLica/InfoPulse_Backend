package com.infopulse.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.infopulse.domain.VinculoGrupoPermissao} entity. This class is used
 * in {@link com.infopulse.web.rest.VinculoGrupoPermissaoResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /vinculo-grupo-permissaos?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class VinculoGrupoPermissaoCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private BooleanFilter ativado;

    private LongFilter grupoUsuarioId;

    private LongFilter permissaoId;

    private Boolean distinct;

    public VinculoGrupoPermissaoCriteria() {}

    public VinculoGrupoPermissaoCriteria(VinculoGrupoPermissaoCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.ativado = other.optionalAtivado().map(BooleanFilter::copy).orElse(null);
        this.grupoUsuarioId = other.optionalGrupoUsuarioId().map(LongFilter::copy).orElse(null);
        this.permissaoId = other.optionalPermissaoId().map(LongFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public VinculoGrupoPermissaoCriteria copy() {
        return new VinculoGrupoPermissaoCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public Optional<LongFilter> optionalId() {
        return Optional.ofNullable(id);
    }

    public LongFilter id() {
        if (id == null) {
            setId(new LongFilter());
        }
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public BooleanFilter getAtivado() {
        return ativado;
    }

    public Optional<BooleanFilter> optionalAtivado() {
        return Optional.ofNullable(ativado);
    }

    public BooleanFilter ativado() {
        if (ativado == null) {
            setAtivado(new BooleanFilter());
        }
        return ativado;
    }

    public void setAtivado(BooleanFilter ativado) {
        this.ativado = ativado;
    }

    public LongFilter getGrupoUsuarioId() {
        return grupoUsuarioId;
    }

    public Optional<LongFilter> optionalGrupoUsuarioId() {
        return Optional.ofNullable(grupoUsuarioId);
    }

    public LongFilter grupoUsuarioId() {
        if (grupoUsuarioId == null) {
            setGrupoUsuarioId(new LongFilter());
        }
        return grupoUsuarioId;
    }

    public void setGrupoUsuarioId(LongFilter grupoUsuarioId) {
        this.grupoUsuarioId = grupoUsuarioId;
    }

    public LongFilter getPermissaoId() {
        return permissaoId;
    }

    public Optional<LongFilter> optionalPermissaoId() {
        return Optional.ofNullable(permissaoId);
    }

    public LongFilter permissaoId() {
        if (permissaoId == null) {
            setPermissaoId(new LongFilter());
        }
        return permissaoId;
    }

    public void setPermissaoId(LongFilter permissaoId) {
        this.permissaoId = permissaoId;
    }

    public Boolean getDistinct() {
        return distinct;
    }

    public Optional<Boolean> optionalDistinct() {
        return Optional.ofNullable(distinct);
    }

    public Boolean distinct() {
        if (distinct == null) {
            setDistinct(true);
        }
        return distinct;
    }

    public void setDistinct(Boolean distinct) {
        this.distinct = distinct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final VinculoGrupoPermissaoCriteria that = (VinculoGrupoPermissaoCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(ativado, that.ativado) &&
            Objects.equals(grupoUsuarioId, that.grupoUsuarioId) &&
            Objects.equals(permissaoId, that.permissaoId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ativado, grupoUsuarioId, permissaoId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "VinculoGrupoPermissaoCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalAtivado().map(f -> "ativado=" + f + ", ").orElse("") +
            optionalGrupoUsuarioId().map(f -> "grupoUsuarioId=" + f + ", ").orElse("") +
            optionalPermissaoId().map(f -> "permissaoId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
