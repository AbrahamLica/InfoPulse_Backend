package com.infopulse.service.mapper;

import com.infopulse.domain.GrupoUsuario;
import com.infopulse.domain.Permissao;
import com.infopulse.domain.VinculoGrupoPermissao;
import com.infopulse.service.dto.GrupoUsuarioDTO;
import com.infopulse.service.dto.PermissaoDTO;
import com.infopulse.service.dto.VinculoGrupoPermissaoDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link VinculoGrupoPermissao} and its DTO {@link VinculoGrupoPermissaoDTO}.
 */
@Mapper(componentModel = "spring")
public interface VinculoGrupoPermissaoMapper extends EntityMapper<VinculoGrupoPermissaoDTO, VinculoGrupoPermissao> {
    @Mapping(target = "grupoUsuario", source = "grupoUsuario", qualifiedByName = "grupoUsuarioId")
    @Mapping(target = "permissao", source = "permissao", qualifiedByName = "permissaoId")
    VinculoGrupoPermissaoDTO toDto(VinculoGrupoPermissao s);

    @Named("grupoUsuarioId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    GrupoUsuarioDTO toDtoGrupoUsuarioId(GrupoUsuario grupoUsuario);

    @Named("permissaoId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    PermissaoDTO toDtoPermissaoId(Permissao permissao);
}
