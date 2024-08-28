package com.infopulse.service.impl;

import com.infopulse.domain.Permissao;
import com.infopulse.repository.PermissaoRepository;
import com.infopulse.service.PermissaoService;
import com.infopulse.service.dto.PermissaoDTO;
import com.infopulse.service.mapper.PermissaoMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.infopulse.domain.Permissao}.
 */
@Service
@Transactional
public class PermissaoServiceImpl implements PermissaoService {

    private static final Logger log = LoggerFactory.getLogger(PermissaoServiceImpl.class);

    private final PermissaoRepository permissaoRepository;

    private final PermissaoMapper permissaoMapper;

    public PermissaoServiceImpl(PermissaoRepository permissaoRepository, PermissaoMapper permissaoMapper) {
        this.permissaoRepository = permissaoRepository;
        this.permissaoMapper = permissaoMapper;
    }

    @Override
    public PermissaoDTO save(PermissaoDTO permissaoDTO) {
        log.debug("Request to save Permissao : {}", permissaoDTO);
        Permissao permissao = permissaoMapper.toEntity(permissaoDTO);
        permissao = permissaoRepository.save(permissao);
        return permissaoMapper.toDto(permissao);
    }

    @Override
    public PermissaoDTO update(PermissaoDTO permissaoDTO) {
        log.debug("Request to update Permissao : {}", permissaoDTO);
        Permissao permissao = permissaoMapper.toEntity(permissaoDTO);
        permissao = permissaoRepository.save(permissao);
        return permissaoMapper.toDto(permissao);
    }

    @Override
    public Optional<PermissaoDTO> partialUpdate(PermissaoDTO permissaoDTO) {
        log.debug("Request to partially update Permissao : {}", permissaoDTO);

        return permissaoRepository
            .findById(permissaoDTO.getId())
            .map(existingPermissao -> {
                permissaoMapper.partialUpdate(existingPermissao, permissaoDTO);

                return existingPermissao;
            })
            .map(permissaoRepository::save)
            .map(permissaoMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PermissaoDTO> findOne(Long id) {
        log.debug("Request to get Permissao : {}", id);
        return permissaoRepository.findById(id).map(permissaoMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Permissao : {}", id);
        permissaoRepository.deleteById(id);
    }
}
