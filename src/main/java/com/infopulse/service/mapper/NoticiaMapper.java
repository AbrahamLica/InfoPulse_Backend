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
    @Mapping(target = "categoria", source = "categoria") // Remova qualifiedByName, assim traz todos os dados
    NoticiaDTO toDto(Noticia s);

    @Named("categoriaId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome") // Adicione todos os campos necessários
    @Mapping(target = "descricao", source = "descricao")
    CategoriaDTO toDtoCategoriaId(Categoria categoria);
}
