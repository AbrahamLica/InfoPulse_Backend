package com.infopulse.web.rest;

import com.infopulse.repository.PalavrasChaveRepository;
import com.infopulse.service.PalavrasChaveQueryService;
import com.infopulse.service.PalavrasChaveService;
import com.infopulse.service.criteria.PalavrasChaveCriteria;
import com.infopulse.service.dto.PalavrasChaveDTO;
import com.infopulse.web.rest.errors.BadRequestAlertException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.infopulse.domain.PalavrasChave}.
 */
@RestController
@RequestMapping("/api/palavras-chaves")
public class PalavrasChaveResource {

    private static final Logger log = LoggerFactory.getLogger(PalavrasChaveResource.class);

    private static final String ENTITY_NAME = "palavrasChave";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PalavrasChaveService palavrasChaveService;

    private final PalavrasChaveRepository palavrasChaveRepository;

    private final PalavrasChaveQueryService palavrasChaveQueryService;

    public PalavrasChaveResource(
        PalavrasChaveService palavrasChaveService,
        PalavrasChaveRepository palavrasChaveRepository,
        PalavrasChaveQueryService palavrasChaveQueryService
    ) {
        this.palavrasChaveService = palavrasChaveService;
        this.palavrasChaveRepository = palavrasChaveRepository;
        this.palavrasChaveQueryService = palavrasChaveQueryService;
    }

    /**
     * {@code POST  /palavras-chaves} : Create a new palavrasChave.
     *
     * @param palavrasChaveDTO the palavrasChaveDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new palavrasChaveDTO, or with status {@code 400 (Bad Request)} if the palavrasChave has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<PalavrasChaveDTO> createPalavrasChave(@Valid @RequestBody PalavrasChaveDTO palavrasChaveDTO)
        throws URISyntaxException {
        log.debug("REST request to save PalavrasChave : {}", palavrasChaveDTO);
        if (palavrasChaveDTO.getId() != null) {
            throw new BadRequestAlertException("A new palavrasChave cannot already have an ID", ENTITY_NAME, "idexists");
        }
        palavrasChaveDTO = palavrasChaveService.save(palavrasChaveDTO);
        return ResponseEntity.created(new URI("/api/palavras-chaves/" + palavrasChaveDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, palavrasChaveDTO.getId().toString()))
            .body(palavrasChaveDTO);
    }

    /**
     * {@code PUT  /palavras-chaves/:id} : Updates an existing palavrasChave.
     *
     * @param id the id of the palavrasChaveDTO to save.
     * @param palavrasChaveDTO the palavrasChaveDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated palavrasChaveDTO,
     * or with status {@code 400 (Bad Request)} if the palavrasChaveDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the palavrasChaveDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<PalavrasChaveDTO> updatePalavrasChave(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody PalavrasChaveDTO palavrasChaveDTO
    ) throws URISyntaxException {
        log.debug("REST request to update PalavrasChave : {}, {}", id, palavrasChaveDTO);
        if (palavrasChaveDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, palavrasChaveDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!palavrasChaveRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        palavrasChaveDTO = palavrasChaveService.update(palavrasChaveDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, palavrasChaveDTO.getId().toString()))
            .body(palavrasChaveDTO);
    }

    /**
     * {@code PATCH  /palavras-chaves/:id} : Partial updates given fields of an existing palavrasChave, field will ignore if it is null
     *
     * @param id the id of the palavrasChaveDTO to save.
     * @param palavrasChaveDTO the palavrasChaveDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated palavrasChaveDTO,
     * or with status {@code 400 (Bad Request)} if the palavrasChaveDTO is not valid,
     * or with status {@code 404 (Not Found)} if the palavrasChaveDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the palavrasChaveDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<PalavrasChaveDTO> partialUpdatePalavrasChave(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody PalavrasChaveDTO palavrasChaveDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update PalavrasChave partially : {}, {}", id, palavrasChaveDTO);
        if (palavrasChaveDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, palavrasChaveDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!palavrasChaveRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<PalavrasChaveDTO> result = palavrasChaveService.partialUpdate(palavrasChaveDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, palavrasChaveDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /palavras-chaves} : get all the palavrasChaves.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of palavrasChaves in body.
     */
    @GetMapping("")
    public ResponseEntity<List<PalavrasChaveDTO>> getAllPalavrasChaves(
        PalavrasChaveCriteria criteria,
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get PalavrasChaves by criteria: {}", criteria);

        Page<PalavrasChaveDTO> page = palavrasChaveQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /palavras-chaves/count} : count all the palavrasChaves.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/count")
    public ResponseEntity<Long> countPalavrasChaves(PalavrasChaveCriteria criteria) {
        log.debug("REST request to count PalavrasChaves by criteria: {}", criteria);
        return ResponseEntity.ok().body(palavrasChaveQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /palavras-chaves/:id} : get the "id" palavrasChave.
     *
     * @param id the id of the palavrasChaveDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the palavrasChaveDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<PalavrasChaveDTO> getPalavrasChave(@PathVariable("id") Long id) {
        log.debug("REST request to get PalavrasChave : {}", id);
        Optional<PalavrasChaveDTO> palavrasChaveDTO = palavrasChaveService.findOne(id);
        return ResponseUtil.wrapOrNotFound(palavrasChaveDTO);
    }

    /**
     * {@code DELETE  /palavras-chaves/:id} : delete the "id" palavrasChave.
     *
     * @param id the id of the palavrasChaveDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePalavrasChave(@PathVariable("id") Long id) {
        log.debug("REST request to delete PalavrasChave : {}", id);
        palavrasChaveService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
            .build();
    }
}
