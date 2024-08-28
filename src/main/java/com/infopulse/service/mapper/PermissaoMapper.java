package com.infopulse.service.mapper;

import com.infopulse.domain.Permissao;
import com.infopulse.service.dto.PermissaoDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Permissao} and its DTO {@link PermissaoDTO}.
 */
@Mapper(componentModel = "spring")
public interface PermissaoMapper extends EntityMapper<PermissaoDTO, Permissao> {}
