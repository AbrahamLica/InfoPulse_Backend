package com.infopulse.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.infopulse.domain.VinculoGrupoPermissao} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class VinculoGrupoPermissaoDTO implements Serializable {

    private Long id;

    private Boolean ativado;

    private GrupoUsuarioDTO grupoUsuario;

    private PermissaoDTO permissao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAtivado() {
        return ativado;
    }

    public void setAtivado(Boolean ativado) {
        this.ativado = ativado;
    }

    public GrupoUsuarioDTO getGrupoUsuario() {
        return grupoUsuario;
    }

    public void setGrupoUsuario(GrupoUsuarioDTO grupoUsuario) {
        this.grupoUsuario = grupoUsuario;
    }

    public PermissaoDTO getPermissao() {
        return permissao;
    }

    public void setPermissao(PermissaoDTO permissao) {
        this.permissao = permissao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VinculoGrupoPermissaoDTO)) {
            return false;
        }

        VinculoGrupoPermissaoDTO vinculoGrupoPermissaoDTO = (VinculoGrupoPermissaoDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, vinculoGrupoPermissaoDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "VinculoGrupoPermissaoDTO{" +
            "id=" + getId() +
            ", ativado='" + getAtivado() + "'" +
            ", grupoUsuario=" + getGrupoUsuario() +
            ", permissao=" + getPermissao() +
            "}";
    }
}
