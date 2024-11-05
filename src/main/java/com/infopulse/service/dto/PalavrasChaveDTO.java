package com.infopulse.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.infopulse.domain.PalavrasChave} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class PalavrasChaveDTO implements Serializable {

    private Long id;

    @NotNull
    private String palavra;

    private NoticiaDTO noticia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public NoticiaDTO getNoticia() {
        return noticia;
    }

    public void setNoticia(NoticiaDTO noticia) {
        this.noticia = noticia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PalavrasChaveDTO)) {
            return false;
        }

        PalavrasChaveDTO palavrasChaveDTO = (PalavrasChaveDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, palavrasChaveDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PalavrasChaveDTO{" +
            "id=" + getId() +
            ", palavra='" + getPalavra() + "'" +
            ", noticia=" + getNoticia() +
            "}";
    }
}
