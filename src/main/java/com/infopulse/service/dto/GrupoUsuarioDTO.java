package com.infopulse.service.dto;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.infopulse.domain.GrupoUsuario} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class GrupoUsuarioDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 2)
    private String nome;

    private String descricao;

    @Lob
    private byte[] imagem;

    private String imagemContentType;

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

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public String getImagemContentType() {
        return imagemContentType;
    }

    public void setImagemContentType(String imagemContentType) {
        this.imagemContentType = imagemContentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GrupoUsuarioDTO)) {
            return false;
        }

        GrupoUsuarioDTO grupoUsuarioDTO = (GrupoUsuarioDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, grupoUsuarioDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "GrupoUsuarioDTO{" +
            "id=" + getId() +
            ", nome='" + getNome() + "'" +
            ", descricao='" + getDescricao() + "'" +
            ", imagem='" + getImagem() + "'" +
            "}";
    }
}
