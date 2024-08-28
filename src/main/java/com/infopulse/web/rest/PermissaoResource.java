package com.infopulse.web.rest;

import com.infopulse.repository.PermissaoRepository;
import com.infopulse.service.PermissaoQueryService;
import com.infopulse.service.PermissaoService;
import com.infopulse.service.criteria.PermissaoCriteria;
import com.infopulse.service.dto.PermissaoDTO;
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
 * REST controller for managing {@link com.infopulse.domain.Permissao}.
 */
@RestController
@RequestMapping("/api/permissaos")
public class PermissaoResource {

    private static final Logger log = LoggerFactory.getLogger(PermissaoResource.class);

    private static final String ENTITY_NAME = "permissao";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PermissaoService permissaoService;

    private final PermissaoRepository permissaoRepository;

    private final PermissaoQueryService permissaoQueryService;

    public PermissaoResource(
        PermissaoService permissaoService,
        PermissaoRepository permissaoRepository,
        PermissaoQueryService permissaoQueryService
    ) {
        this.permissaoService = permissaoService;
        this.permissaoRepository = permissaoRepository;
        this.permissaoQueryService = permissaoQueryService;
    }

    /**
     * {@code POST  /permissaos} : Create a new permissao.
     *
     * @param permissaoDTO the permissaoDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new permissaoDTO, or with status {@code 400 (Bad Request)} if the permissao has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<PermissaoDTO> createPermissao(@Valid @RequestBody PermissaoDTO permissaoDTO) throws URISyntaxException {
        log.debug("REST request to save Permissao : {}", permissaoDTO);
        if (permissaoDTO.getId() != null) {
            throw new BadRequestAlertException("A new permissao cannot already have an ID", ENTITY_NAME, "idexists");
        }
        permissaoDTO = permissaoService.save(permissaoDTO);
        return ResponseEntity.created(new URI("/api/permissaos/" + permissaoDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, permissaoDTO.getId().toString()))
            .body(permissaoDTO);
    }

    /**
     * {@code PUT  /permissaos/:id} : Updates an existing permissao.
     *
     * @param id the id of the permissaoDTO to save.
     * @param permissaoDTO the permissaoDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated permissaoDTO,
     * or with status {@code 400 (Bad Request)} if the permissaoDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the permissaoDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<PermissaoDTO> updatePermissao(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody PermissaoDTO permissaoDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Permissao : {}, {}", id, permissaoDTO);
        if (permissaoDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, permissaoDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!permissaoRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        permissaoDTO = permissaoService.update(permissaoDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, permissaoDTO.getId().toString()))
            .body(permissaoDTO);
    }

    /**
     * {@code PATCH  /permissaos/:id} : Partial updates given fields of an existing permissao, field will ignore if it is null
     *
     * @param id the id of the permissaoDTO to save.
     * @param permissaoDTO the permissaoDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated permissaoDTO,
     * or with status {@code 400 (Bad Request)} if the permissaoDTO is not valid,
     * or with status {@code 404 (Not Found)} if the permissaoDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the permissaoDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<PermissaoDTO> partialUpdatePermissao(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody PermissaoDTO permissaoDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Permissao partially : {}, {}", id, permissaoDTO);
        if (permissaoDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, permissaoDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!permissaoRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<PermissaoDTO> result = permissaoService.partialUpdate(permissaoDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, permissaoDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /permissaos} : get all the permissaos.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of permissaos in body.
     */
    @GetMapping("")
    public ResponseEntity<List<PermissaoDTO>> getAllPermissaos(
        PermissaoCriteria criteria,
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get Permissaos by criteria: {}", criteria);

        Page<PermissaoDTO> page = permissaoQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /permissaos/count} : count all the permissaos.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/count")
    public ResponseEntity<Long> countPermissaos(PermissaoCriteria criteria) {
        log.debug("REST request to count Permissaos by criteria: {}", criteria);
        return ResponseEntity.ok().body(permissaoQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /permissaos/:id} : get the "id" permissao.
     *
     * @param id the id of the permissaoDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the permissaoDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<PermissaoDTO> getPermissao(@PathVariable("id") Long id) {
        log.debug("REST request to get Permissao : {}", id);
        Optional<PermissaoDTO> permissaoDTO = permissaoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(permissaoDTO);
    }

    /**
     * {@code DELETE  /permissaos/:id} : delete the "id" permissao.
     *
     * @param id the id of the permissaoDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePermissao(@PathVariable("id") Long id) {
        log.debug("REST request to delete Permissao : {}", id);
        permissaoService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
            .build();
    }
}
