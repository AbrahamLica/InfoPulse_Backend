package com.infopulse.service.impl;

import com.infopulse.domain.GrupoUsuario;
import com.infopulse.repository.GrupoUsuarioRepository;
import com.infopulse.service.GrupoUsuarioService;
import com.infopulse.service.dto.GrupoUsuarioDTO;
import com.infopulse.service.mapper.GrupoUsuarioMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.infopulse.domain.GrupoUsuario}.
 */
@Service
@Transactional
public class GrupoUsuarioServiceImpl implements GrupoUsuarioService {

    private static final Logger log = LoggerFactory.getLogger(GrupoUsuarioServiceImpl.class);

    private final GrupoUsuarioRepository grupoUsuarioRepository;

    private final GrupoUsuarioMapper grupoUsuarioMapper;

    public GrupoUsuarioServiceImpl(GrupoUsuarioRepository grupoUsuarioRepository, GrupoUsuarioMapper grupoUsuarioMapper) {
        this.grupoUsuarioRepository = grupoUsuarioRepository;
        this.grupoUsuarioMapper = grupoUsuarioMapper;
    }

    @Override
    public GrupoUsuarioDTO save(GrupoUsuarioDTO grupoUsuarioDTO) {
        log.debug("Request to save GrupoUsuario : {}", grupoUsuarioDTO);
        GrupoUsuario grupoUsuario = grupoUsuarioMapper.toEntity(grupoUsuarioDTO);
        grupoUsuario = grupoUsuarioRepository.save(grupoUsuario);
        return grupoUsuarioMapper.toDto(grupoUsuario);
    }

    @Override
    public GrupoUsuarioDTO update(GrupoUsuarioDTO grupoUsuarioDTO) {
        log.debug("Request to update GrupoUsuario : {}", grupoUsuarioDTO);
        GrupoUsuario grupoUsuario = grupoUsuarioMapper.toEntity(grupoUsuarioDTO);
        grupoUsuario = grupoUsuarioRepository.save(grupoUsuario);
        return grupoUsuarioMapper.toDto(grupoUsuario);
    }

    @Override
    public Optional<GrupoUsuarioDTO> partialUpdate(GrupoUsuarioDTO grupoUsuarioDTO) {
        log.debug("Request to partially update GrupoUsuario : {}", grupoUsuarioDTO);

        return grupoUsuarioRepository
            .findById(grupoUsuarioDTO.getId())
            .map(existingGrupoUsuario -> {
                grupoUsuarioMapper.partialUpdate(existingGrupoUsuario, grupoUsuarioDTO);

                return existingGrupoUsuario;
            })
            .map(grupoUsuarioRepository::save)
            .map(grupoUsuarioMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<GrupoUsuarioDTO> findOne(Long id) {
        log.debug("Request to get GrupoUsuario : {}", id);
        return grupoUsuarioRepository.findById(id).map(grupoUsuarioMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete GrupoUsuario : {}", id);
        grupoUsuarioRepository.deleteById(id);
    }
}
