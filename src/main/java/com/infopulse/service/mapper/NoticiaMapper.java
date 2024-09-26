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
    @Mapping(target = "categoria", source = "categoria")
    NoticiaDTO toDto(Noticia noticia);

    @Named("categoriaDetails")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "descricao", source = "descricao") // Aqui você pode mapear outros atributos da categoria
    CategoriaDTO toDtoCategoria(Categoria categoria);
}
