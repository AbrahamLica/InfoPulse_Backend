package com.infopulse.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.infopulse.domain.Noticia} entity. This class is used
 * in {@link com.infopulse.web.rest.NoticiaResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /noticias?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class NoticiaCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter titulo;

    private InstantFilter dataPublicacao;

    private StringFilter autor;

    private BooleanFilter ativo;

    private LongFilter categoriaId;

    private LongFilter autorId;

    private Boolean distinct;

    public NoticiaCriteria() {}

    public NoticiaCriteria(NoticiaCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.titulo = other.optionalTitulo().map(StringFilter::copy).orElse(null);
        this.dataPublicacao = other.optionalDataPublicacao().map(InstantFilter::copy).orElse(null);
        this.autor = other.optionalAutor().map(StringFilter::copy).orElse(null);
        this.ativo = other.optionalAtivo().map(BooleanFilter::copy).orElse(null);
        this.categoriaId = other.optionalCategoriaId().map(LongFilter::copy).orElse(null);
        this.autorId = other.optionalAutorId().map(LongFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public NoticiaCriteria copy() {
        return new NoticiaCriteria(this);
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

    public StringFilter getTitulo() {
        return titulo;
    }

    public Optional<StringFilter> optionalTitulo() {
        return Optional.ofNullable(titulo);
    }

    public StringFilter titulo() {
        if (titulo == null) {
            setTitulo(new StringFilter());
        }
        return titulo;
    }

    public void setTitulo(StringFilter titulo) {
        this.titulo = titulo;
    }

    public InstantFilter getDataPublicacao() {
        return dataPublicacao;
    }

    public Optional<InstantFilter> optionalDataPublicacao() {
        return Optional.ofNullable(dataPublicacao);
    }

    public InstantFilter dataPublicacao() {
        if (dataPublicacao == null) {
            setDataPublicacao(new InstantFilter());
        }
        return dataPublicacao;
    }

    public void setDataPublicacao(InstantFilter dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public StringFilter getAutor() {
        return autor;
    }

    public Optional<StringFilter> optionalAutor() {
        return Optional.ofNullable(autor);
    }

    public StringFilter autor() {
        if (autor == null) {
            setAutor(new StringFilter());
        }
        return autor;
    }

    public void setAutor(StringFilter autor) {
        this.autor = autor;
    }

    public BooleanFilter getAtivo() {
        return ativo;
    }

    public Optional<BooleanFilter> optionalAtivo() {
        return Optional.ofNullable(ativo);
    }

    public BooleanFilter ativo() {
        if (ativo == null) {
            setAtivo(new BooleanFilter());
        }
        return ativo;
    }

    public void setAtivo(BooleanFilter ativo) {
        this.ativo = ativo;
    }

    public LongFilter getCategoriaId() {
        return categoriaId;
    }

    public Optional<LongFilter> optionalCategoriaId() {
        return Optional.ofNullable(categoriaId);
    }

    public LongFilter categoriaId() {
        if (categoriaId == null) {
            setCategoriaId(new LongFilter());
        }
        return categoriaId;
    }

    public void setCategoriaId(LongFilter categoriaId) {
        this.categoriaId = categoriaId;
    }

    public LongFilter getAutorId() {
        return autorId;
    }

    public Optional<LongFilter> optionalAutorId() {
        return Optional.ofNullable(autorId);
    }

    public LongFilter autorId() {
        if (autorId == null) {
            setAutorId(new LongFilter());
        }
        return autorId;
    }

    public void setAutorId(LongFilter autorId) {
        this.autorId = autorId;
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
        final NoticiaCriteria that = (NoticiaCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(titulo, that.titulo) &&
            Objects.equals(dataPublicacao, that.dataPublicacao) &&
            Objects.equals(autor, that.autor) &&
            Objects.equals(ativo, that.ativo) &&
            Objects.equals(categoriaId, that.categoriaId) &&
            Objects.equals(autorId, that.autorId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, dataPublicacao, autor, ativo, categoriaId, autorId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "NoticiaCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalTitulo().map(f -> "titulo=" + f + ", ").orElse("") +
            optionalDataPublicacao().map(f -> "dataPublicacao=" + f + ", ").orElse("") +
            optionalAutor().map(f -> "autor=" + f + ", ").orElse("") +
            optionalAtivo().map(f -> "ativo=" + f + ", ").orElse("") +
            optionalCategoriaId().map(f -> "categoriaId=" + f + ", ").orElse("") +
            optionalAutorId().map(f -> "autorId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
