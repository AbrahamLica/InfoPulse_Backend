package com.infopulse.domain;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 * A VinculoGrupoPermissao.
 */
@Entity
@Table(name = "vinculo_grupo_permissao")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class VinculoGrupoPermissao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "ativado")
    private Boolean ativado;

    @ManyToOne(fetch = FetchType.LAZY)
    private GrupoUsuario grupoUsuario;

    @ManyToOne(fetch = FetchType.LAZY)
    private Permissao permissao;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public VinculoGrupoPermissao id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAtivado() {
        return this.ativado;
    }

    public VinculoGrupoPermissao ativado(Boolean ativado) {
        this.setAtivado(ativado);
        return this;
    }

    public void setAtivado(Boolean ativado) {
        this.ativado = ativado;
    }

    public GrupoUsuario getGrupoUsuario() {
        return this.grupoUsuario;
    }

    public void setGrupoUsuario(GrupoUsuario grupoUsuario) {
        this.grupoUsuario = grupoUsuario;
    }

    public VinculoGrupoPermissao grupoUsuario(GrupoUsuario grupoUsuario) {
        this.setGrupoUsuario(grupoUsuario);
        return this;
    }

    public Permissao getPermissao() {
        return this.permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }

    public VinculoGrupoPermissao permissao(Permissao permissao) {
        this.setPermissao(permissao);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VinculoGrupoPermissao)) {
            return false;
        }
        return getId() != null && getId().equals(((VinculoGrupoPermissao) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "VinculoGrupoPermissao{" +
            "id=" + getId() +
            ", ativado='" + getAtivado() + "'" +
            "}";
    }
}
