package com.infopulse.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * A Noticia.
 */
@Entity
@Table(name = "noticia")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Noticia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 5)
    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Lob
    @Column(name = "conteudo", nullable = false)
    private String conteudo;

    @Lob
    @Column(name = "resumo")
    private String resumo;

    @NotNull
    @Column(name = "data_publicacao", nullable = false)
    private Instant dataPublicacao;

    @Column(name = "data_ultima_modificacao", nullable = false)
    private Instant dataUltimaModificacao;

    @NotNull
    @Size(min = 2)
    @Column(name = "autor", nullable = false)
    private String autor;

    @NotNull
    @Column(name = "ativo", nullable = false)
    private Boolean ativo;

    @Lob
    @Column(name = "imagem")
    private byte[] imagem;

    @Column(name = "imagem_content_type")
    private String imagemContentType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = { "noticias" }, allowSetters = true)
    private Categoria categoria;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "noticias")
    @JsonIgnoreProperties(value = { "noticias" }, allowSetters = true)
    private Set<Usuario> autors = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Noticia id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public Noticia titulo(String titulo) {
        this.setTitulo(titulo);
        return this;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return this.conteudo;
    }

    public Noticia conteudo(String conteudo) {
        this.setConteudo(conteudo);
        return this;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getResumo() {
        return this.resumo;
    }

    public Noticia resumo(String resumo) {
        this.setResumo(resumo);
        return this;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public Instant getDataPublicacao() {
        return this.dataPublicacao;
    }

    public Noticia dataPublicacao(Instant dataPublicacao) {
        this.setDataPublicacao(dataPublicacao);
        return this;
    }

    public void setDataPublicacao(Instant dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Instant getDataUltimaModificacao() {
        return dataUltimaModificacao;
    }

    public void setDataUltimaModificacao(Instant dataUltimaModificacao) {
        this.dataUltimaModificacao = dataUltimaModificacao;
    }

    public Noticia dataUltimaModificacao(Instant dataUltimaModificacao) {
        this.setDataUltimaModificacao(dataUltimaModificacao);
        return this;
    }

    public String getAutor() {
        return this.autor;
    }

    public Noticia autor(String autor) {
        this.setAutor(autor);
        return this;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Boolean getAtivo() {
        return this.ativo;
    }

    public Noticia ativo(Boolean ativo) {
        this.setAtivo(ativo);
        return this;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public byte[] getImagem() {
        return this.imagem;
    }

    public Noticia imagem(byte[] imagem) {
        this.setImagem(imagem);
        return this;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public String getImagemContentType() {
        return this.imagemContentType;
    }

    public Noticia imagemContentType(String imagemContentType) {
        this.imagemContentType = imagemContentType;
        return this;
    }

    public void setImagemContentType(String imagemContentType) {
        this.imagemContentType = imagemContentType;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Noticia categoria(Categoria categoria) {
        this.setCategoria(categoria);
        return this;
    }

    public Set<Usuario> getAutors() {
        return this.autors;
    }

    public void setAutors(Set<Usuario> usuarios) {
        if (this.autors != null) {
            this.autors.forEach(i -> i.setNoticias(null));
        }
        if (usuarios != null) {
            usuarios.forEach(i -> i.setNoticias(this));
        }
        this.autors = usuarios;
    }

    public Noticia autors(Set<Usuario> usuarios) {
        this.setAutors(usuarios);
        return this;
    }

    public Noticia addAutor(Usuario usuario) {
        this.autors.add(usuario);
        usuario.setNoticias(this);
        return this;
    }

    public Noticia removeAutor(Usuario usuario) {
        this.autors.remove(usuario);
        usuario.setNoticias(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Noticia)) {
            return false;
        }
        return getId() != null && getId().equals(((Noticia) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Noticia{" +
            "id=" + getId() +
            ", titulo='" + getTitulo() + "'" +
            ", conteudo='" + getConteudo() + "'" +
            ", resumo='" + getResumo() + "'" +
            ", dataPublicacao='" + getDataPublicacao() + "'" +
            ", autor='" + getAutor() + "'" +
            ", ativo='" + getAtivo() + "'" +
            ", imagem='" + getImagem() + "'" +
            ", imagemContentType='" + getImagemContentType() + "'" +
            "}";
    }
}
