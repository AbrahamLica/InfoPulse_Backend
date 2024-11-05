package com.infopulse.repository;

import com.infopulse.domain.PalavrasChave;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the PalavrasChave entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PalavrasChaveRepository extends JpaRepository<PalavrasChave, Long>, JpaSpecificationExecutor<PalavrasChave> {}
