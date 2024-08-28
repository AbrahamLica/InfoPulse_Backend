package com.infopulse.service.impl;

import com.infopulse.domain.Noticia;
import com.infopulse.repository.NoticiaRepository;
import com.infopulse.service.NoticiaService;
import com.infopulse.service.dto.NoticiaDTO;
import com.infopulse.service.mapper.NoticiaMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.infopulse.domain.Noticia}.
 */
@Service
@Transactional
public class NoticiaServiceImpl implements NoticiaService {

    private static final Logger log = LoggerFactory.getLogger(NoticiaServiceImpl.class);

    private final NoticiaRepository noticiaRepository;

    private final NoticiaMapper noticiaMapper;

    public NoticiaServiceImpl(NoticiaRepository noticiaRepository, NoticiaMapper noticiaMapper) {
        this.noticiaRepository = noticiaRepository;
        this.noticiaMapper = noticiaMapper;
    }

    @Override
    public NoticiaDTO save(NoticiaDTO noticiaDTO) {
        log.debug("Request to save Noticia : {}", noticiaDTO);
        Noticia noticia = noticiaMapper.toEntity(noticiaDTO);
        noticia = noticiaRepository.save(noticia);
        return noticiaMapper.toDto(noticia);
    }

    @Override
    public NoticiaDTO update(NoticiaDTO noticiaDTO) {
        log.debug("Request to update Noticia : {}", noticiaDTO);
        Noticia noticia = noticiaMapper.toEntity(noticiaDTO);
        noticia = noticiaRepository.save(noticia);
        return noticiaMapper.toDto(noticia);
    }

    @Override
    public Optional<NoticiaDTO> partialUpdate(NoticiaDTO noticiaDTO) {
        log.debug("Request to partially update Noticia : {}", noticiaDTO);

        return noticiaRepository
            .findById(noticiaDTO.getId())
            .map(existingNoticia -> {
                noticiaMapper.partialUpdate(existingNoticia, noticiaDTO);

                return existingNoticia;
            })
            .map(noticiaRepository::save)
            .map(noticiaMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<NoticiaDTO> findOne(Long id) {
        log.debug("Request to get Noticia : {}", id);
        return noticiaRepository.findById(id).map(noticiaMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Noticia : {}", id);
        noticiaRepository.deleteById(id);
    }
}
