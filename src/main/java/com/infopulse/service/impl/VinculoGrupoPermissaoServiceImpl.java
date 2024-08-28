package com.infopulse.service.impl;

import com.infopulse.domain.VinculoGrupoPermissao;
import com.infopulse.repository.VinculoGrupoPermissaoRepository;
import com.infopulse.service.VinculoGrupoPermissaoService;
import com.infopulse.service.dto.VinculoGrupoPermissaoDTO;
import com.infopulse.service.mapper.VinculoGrupoPermissaoMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.infopulse.domain.VinculoGrupoPermissao}.
 */
@Service
@Transactional
public class VinculoGrupoPermissaoServiceImpl implements VinculoGrupoPermissaoService {

    private static final Logger log = LoggerFactory.getLogger(VinculoGrupoPermissaoServiceImpl.class);

    private final VinculoGrupoPermissaoRepository vinculoGrupoPermissaoRepository;

    private final VinculoGrupoPermissaoMapper vinculoGrupoPermissaoMapper;

    public VinculoGrupoPermissaoServiceImpl(
        VinculoGrupoPermissaoRepository vinculoGrupoPermissaoRepository,
        VinculoGrupoPermissaoMapper vinculoGrupoPermissaoMapper
    ) {
        this.vinculoGrupoPermissaoRepository = vinculoGrupoPermissaoRepository;
        this.vinculoGrupoPermissaoMapper = vinculoGrupoPermissaoMapper;
    }

    @Override
    public VinculoGrupoPermissaoDTO save(VinculoGrupoPermissaoDTO vinculoGrupoPermissaoDTO) {
        log.debug("Request to save VinculoGrupoPermissao : {}", vinculoGrupoPermissaoDTO);
        VinculoGrupoPermissao vinculoGrupoPermissao = vinculoGrupoPermissaoMapper.toEntity(vinculoGrupoPermissaoDTO);
        vinculoGrupoPermissao = vinculoGrupoPermissaoRepository.save(vinculoGrupoPermissao);
        return vinculoGrupoPermissaoMapper.toDto(vinculoGrupoPermissao);
    }

    @Override
    public VinculoGrupoPermissaoDTO update(VinculoGrupoPermissaoDTO vinculoGrupoPermissaoDTO) {
        log.debug("Request to update VinculoGrupoPermissao : {}", vinculoGrupoPermissaoDTO);
        VinculoGrupoPermissao vinculoGrupoPermissao = vinculoGrupoPermissaoMapper.toEntity(vinculoGrupoPermissaoDTO);
        vinculoGrupoPermissao = vinculoGrupoPermissaoRepository.save(vinculoGrupoPermissao);
        return vinculoGrupoPermissaoMapper.toDto(vinculoGrupoPermissao);
    }

    @Override
    public Optional<VinculoGrupoPermissaoDTO> partialUpdate(VinculoGrupoPermissaoDTO vinculoGrupoPermissaoDTO) {
        log.debug("Request to partially update VinculoGrupoPermissao : {}", vinculoGrupoPermissaoDTO);

        return vinculoGrupoPermissaoRepository
            .findById(vinculoGrupoPermissaoDTO.getId())
            .map(existingVinculoGrupoPermissao -> {
                vinculoGrupoPermissaoMapper.partialUpdate(existingVinculoGrupoPermissao, vinculoGrupoPermissaoDTO);

                return existingVinculoGrupoPermissao;
            })
            .map(vinculoGrupoPermissaoRepository::save)
            .map(vinculoGrupoPermissaoMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<VinculoGrupoPermissaoDTO> findOne(Long id) {
        log.debug("Request to get VinculoGrupoPermissao : {}", id);
        return vinculoGrupoPermissaoRepository.findById(id).map(vinculoGrupoPermissaoMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete VinculoGrupoPermissao : {}", id);
        vinculoGrupoPermissaoRepository.deleteById(id);
    }
}
