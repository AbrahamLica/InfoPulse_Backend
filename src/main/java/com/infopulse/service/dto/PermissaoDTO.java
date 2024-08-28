package com.infopulse.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.infopulse.domain.Permissao} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class PermissaoDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 2)
    private String nome;

    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PermissaoDTO)) {
            return false;
        }

        PermissaoDTO permissaoDTO = (PermissaoDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, permissaoDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PermissaoDTO{" +
            "id=" + getId() +
            ", nome='" + getNome() + "'" +
            ", descricao='" + getDescricao() + "'" +
            "}";
    }
}
