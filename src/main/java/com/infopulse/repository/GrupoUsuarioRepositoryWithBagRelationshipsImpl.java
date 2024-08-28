package com.infopulse.repository;

import com.infopulse.domain.GrupoUsuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

/**
 * Utility repository to load bag relationships based on https://vladmihalcea.com/hibernate-multiplebagfetchexception/
 */
public class GrupoUsuarioRepositoryWithBagRelationshipsImpl implements GrupoUsuarioRepositoryWithBagRelationships {

    private static final String ID_PARAMETER = "id";
    private static final String GRUPOUSUARIOS_PARAMETER = "grupoUsuarios";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<GrupoUsuario> fetchBagRelationships(Optional<GrupoUsuario> grupoUsuario) {
        return grupoUsuario.map(this::fetchPermissaos);
    }

    @Override
    public Page<GrupoUsuario> fetchBagRelationships(Page<GrupoUsuario> grupoUsuarios) {
        return new PageImpl<>(
            fetchBagRelationships(grupoUsuarios.getContent()),
            grupoUsuarios.getPageable(),
            grupoUsuarios.getTotalElements()
        );
    }

    @Override
    public List<GrupoUsuario> fetchBagRelationships(List<GrupoUsuario> grupoUsuarios) {
        return Optional.of(grupoUsuarios).map(this::fetchPermissaos).orElse(Collections.emptyList());
    }

    GrupoUsuario fetchPermissaos(GrupoUsuario result) {
        return entityManager
            .createQuery(
                "select grupoUsuario from GrupoUsuario grupoUsuario left join fetch grupoUsuario.permissaos where grupoUsuario.id = :id",
                GrupoUsuario.class
            )
            .setParameter(ID_PARAMETER, result.getId())
            .getSingleResult();
    }

    List<GrupoUsuario> fetchPermissaos(List<GrupoUsuario> grupoUsuarios) {
        HashMap<Object, Integer> order = new HashMap<>();
        IntStream.range(0, grupoUsuarios.size()).forEach(index -> order.put(grupoUsuarios.get(index).getId(), index));
        List<GrupoUsuario> result = entityManager
            .createQuery(
                "select grupoUsuario from GrupoUsuario grupoUsuario left join fetch grupoUsuario.permissaos where grupoUsuario in :grupoUsuarios",
                GrupoUsuario.class
            )
            .setParameter(GRUPOUSUARIOS_PARAMETER, grupoUsuarios)
            .getResultList();
        Collections.sort(result, (o1, o2) -> Integer.compare(order.get(o1.getId()), order.get(o2.getId())));
        return result;
    }
}
