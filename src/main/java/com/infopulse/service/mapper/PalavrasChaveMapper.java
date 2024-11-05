package com.infopulse.service.mapper;

import com.infopulse.domain.Noticia;
import com.infopulse.domain.PalavrasChave;
import com.infopulse.service.dto.NoticiaDTO;
import com.infopulse.service.dto.PalavrasChaveDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link PalavrasChave} and its DTO {@link PalavrasChaveDTO}.
 */
@Mapper(componentModel = "spring")
public interface PalavrasChaveMapper extends EntityMapper<PalavrasChaveDTO, PalavrasChave> {
    @Mapping(target = "noticia", source = "noticia", qualifiedByName = "noticiaId")
    PalavrasChaveDTO toDto(PalavrasChave s);

    @Named("noticiaId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    NoticiaDTO toDtoNoticiaId(Noticia noticia);
}
