package com.infopulse.repository;

import com.infopulse.domain.Noticia;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Noticia entity.
 */
@SuppressWarnings("unused")
@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Long>, JpaSpecificationExecutor<Noticia> {}
