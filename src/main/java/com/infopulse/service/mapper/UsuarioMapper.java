package com.infopulse.service.mapper;

import com.infopulse.domain.Noticia;
import com.infopulse.domain.Usuario;
import com.infopulse.service.dto.NoticiaDTO;
import com.infopulse.service.dto.UsuarioDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Usuario} and its DTO {@link UsuarioDTO}.
 */
@Mapper(componentModel = "spring")
public interface UsuarioMapper extends EntityMapper<UsuarioDTO, Usuario> {
    @Mapping(target = "noticias", source = "noticias", qualifiedByName = "noticiaId")
    UsuarioDTO toDto(Usuario s);

    @Named("noticiaId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    NoticiaDTO toDtoNoticiaId(Noticia noticia);
}
