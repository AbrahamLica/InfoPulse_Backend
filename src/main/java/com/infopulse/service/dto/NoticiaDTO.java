package com.infopulse.service.dto;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link com.infopulse.domain.Noticia} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class NoticiaDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 5)
    private String titulo;

    @Lob
    private String conteudo;

    @Lob
    private String resumo;

    @NotNull
    private Instant dataPublicacao;

    @NotNull
    @Size(min = 2)
    private String autor;

    @NotNull
    private Boolean ativo;

    @Lob
    private byte[] imagem;

    private String imagemContentType;

    private CategoriaDTO categoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public Instant getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Instant dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
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

    public CategoriaDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDTO categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NoticiaDTO)) {
            return false;
        }

        NoticiaDTO noticiaDTO = (NoticiaDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, noticiaDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "NoticiaDTO{" +
            "id=" + getId() +
            ", titulo='" + getTitulo() + "'" +
            ", conteudo='" + getConteudo() + "'" +
            ", resumo='" + getResumo() + "'" +
            ", dataPublicacao='" + getDataPublicacao() + "'" +
            ", autor='" + getAutor() + "'" +
            ", ativo='" + getAtivo() + "'" +
            ", imagem='" + getImagem() + "'" +
            ", categoria=" + getCategoria() +
            "}";
    }
}
