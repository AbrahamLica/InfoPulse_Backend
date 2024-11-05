package com.infopulse.service.mapper;

import com.infopulse.domain.Categoria;
import com.infopulse.domain.Noticia;
import com.infopulse.service.dto.CategoriaDTO;
import com.infopulse.service.dto.NoticiaDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Noticia} and its DTO {@link NoticiaDTO}.
 */
@Mapper(componentModel = "spring")
public interface NoticiaMapper extends EntityMapper<NoticiaDTO, Noticia> {
    @Mapping(target = "categoria", source = "categoria", qualifiedByName = "categoriaId")
    NoticiaDTO toDto(Noticia s);

    @Named("categoriaId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    CategoriaDTO toDtoCategoriaId(Categoria categoria);
}
