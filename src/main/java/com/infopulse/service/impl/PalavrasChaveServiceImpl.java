package com.infopulse.service.impl;

import com.infopulse.domain.PalavrasChave;
import com.infopulse.repository.PalavrasChaveRepository;
import com.infopulse.service.PalavrasChaveService;
import com.infopulse.service.dto.PalavrasChaveDTO;
import com.infopulse.service.mapper.PalavrasChaveMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.infopulse.domain.PalavrasChave}.
 */
@Service
@Transactional
public class PalavrasChaveServiceImpl implements PalavrasChaveService {

    private static final Logger log = LoggerFactory.getLogger(PalavrasChaveServiceImpl.class);

    private final PalavrasChaveRepository palavrasChaveRepository;

    private final PalavrasChaveMapper palavrasChaveMapper;

    public PalavrasChaveServiceImpl(PalavrasChaveRepository palavrasChaveRepository, PalavrasChaveMapper palavrasChaveMapper) {
        this.palavrasChaveRepository = palavrasChaveRepository;
        this.palavrasChaveMapper = palavrasChaveMapper;
    }

    @Override
    public PalavrasChaveDTO save(PalavrasChaveDTO palavrasChaveDTO) {
        log.debug("Request to save PalavrasChave : {}", palavrasChaveDTO);
        PalavrasChave palavrasChave = palavrasChaveMapper.toEntity(palavrasChaveDTO);
        palavrasChave = palavrasChaveRepository.save(palavrasChave);
        return palavrasChaveMapper.toDto(palavrasChave);
    }

    @Override
    public PalavrasChaveDTO update(PalavrasChaveDTO palavrasChaveDTO) {
        log.debug("Request to update PalavrasChave : {}", palavrasChaveDTO);
        PalavrasChave palavrasChave = palavrasChaveMapper.toEntity(palavrasChaveDTO);
        palavrasChave = palavrasChaveRepository.save(palavrasChave);
        return palavrasChaveMapper.toDto(palavrasChave);
    }

    @Override
    public Optional<PalavrasChaveDTO> partialUpdate(PalavrasChaveDTO palavrasChaveDTO) {
        log.debug("Request to partially update PalavrasChave : {}", palavrasChaveDTO);

        return palavrasChaveRepository
            .findById(palavrasChaveDTO.getId())
            .map(existingPalavrasChave -> {
                palavrasChaveMapper.partialUpdate(existingPalavrasChave, palavrasChaveDTO);

                return existingPalavrasChave;
            })
            .map(palavrasChaveRepository::save)
            .map(palavrasChaveMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PalavrasChaveDTO> findOne(Long id) {
        log.debug("Request to get PalavrasChave : {}", id);
        return palavrasChaveRepository.findById(id).map(palavrasChaveMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete PalavrasChave : {}", id);
        palavrasChaveRepository.deleteById(id);
    }
}
