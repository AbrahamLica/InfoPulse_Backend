package com.infopulse.service.mapper;

import com.infopulse.domain.GrupoUsuario;
import com.infopulse.service.dto.GrupoUsuarioDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link GrupoUsuario} and its DTO {@link GrupoUsuarioDTO}.
 */
@Mapper(componentModel = "spring")
public interface GrupoUsuarioMapper extends EntityMapper<GrupoUsuarioDTO, GrupoUsuario> {}
