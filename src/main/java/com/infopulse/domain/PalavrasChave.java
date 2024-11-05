package com.infopulse.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;

/**
 * A PalavrasChave.
 */
@Entity
@Table(name = "palavras_chave")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class PalavrasChave implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "palavra", nullable = false)
    private String palavra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = { "categoria", "autors" }, allowSetters = true)
    private Noticia noticia;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public PalavrasChave id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPalavra() {
        return this.palavra;
    }

    public PalavrasChave palavra(String palavra) {
        this.setPalavra(palavra);
        return this;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public Noticia getNoticia() {
        return this.noticia;
    }

    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }

    public PalavrasChave noticia(Noticia noticia) {
        this.setNoticia(noticia);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PalavrasChave)) {
            return false;
        }
        return getId() != null && getId().equals(((PalavrasChave) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PalavrasChave{" +
            "id=" + getId() +
            ", palavra='" + getPalavra() + "'" +
            "}";
    }
}
