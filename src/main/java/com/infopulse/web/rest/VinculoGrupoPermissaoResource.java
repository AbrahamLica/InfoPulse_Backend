package com.infopulse.web.rest;

import com.infopulse.repository.VinculoGrupoPermissaoRepository;
import com.infopulse.service.VinculoGrupoPermissaoQueryService;
import com.infopulse.service.VinculoGrupoPermissaoService;
import com.infopulse.service.criteria.VinculoGrupoPermissaoCriteria;
import com.infopulse.service.dto.VinculoGrupoPermissaoDTO;
import com.infopulse.web.rest.errors.BadRequestAlertException;
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
 * REST controller for managing {@link com.infopulse.domain.VinculoGrupoPermissao}.
 */
@RestController
@RequestMapping("/api/vinculo-grupo-permissaos")
public class VinculoGrupoPermissaoResource {

    private static final Logger log = LoggerFactory.getLogger(VinculoGrupoPermissaoResource.class);

    private static final String ENTITY_NAME = "vinculoGrupoPermissao";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final VinculoGrupoPermissaoService vinculoGrupoPermissaoService;

    private final VinculoGrupoPermissaoRepository vinculoGrupoPermissaoRepository;

    private final VinculoGrupoPermissaoQueryService vinculoGrupoPermissaoQueryService;

    public VinculoGrupoPermissaoResource(
        VinculoGrupoPermissaoService vinculoGrupoPermissaoService,
        VinculoGrupoPermissaoRepository vinculoGrupoPermissaoRepository,
        VinculoGrupoPermissaoQueryService vinculoGrupoPermissaoQueryService
    ) {
        this.vinculoGrupoPermissaoService = vinculoGrupoPermissaoService;
        this.vinculoGrupoPermissaoRepository = vinculoGrupoPermissaoRepository;
        this.vinculoGrupoPermissaoQueryService = vinculoGrupoPermissaoQueryService;
    }

    /**
     * {@code POST  /vinculo-grupo-permissaos} : Create a new vinculoGrupoPermissao.
     *
     * @param vinculoGrupoPermissaoDTO the vinculoGrupoPermissaoDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new vinculoGrupoPermissaoDTO, or with status {@code 400 (Bad Request)} if the vinculoGrupoPermissao has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<VinculoGrupoPermissaoDTO> createVinculoGrupoPermissao(
        @RequestBody VinculoGrupoPermissaoDTO vinculoGrupoPermissaoDTO
    ) throws URISyntaxException {
        log.debug("REST request to save VinculoGrupoPermissao : {}", vinculoGrupoPermissaoDTO);
        if (vinculoGrupoPermissaoDTO.getId() != null) {
            throw new BadRequestAlertException("A new vinculoGrupoPermissao cannot already have an ID", ENTITY_NAME, "idexists");
        }
        vinculoGrupoPermissaoDTO = vinculoGrupoPermissaoService.save(vinculoGrupoPermissaoDTO);
        return ResponseEntity.created(new URI("/api/vinculo-grupo-permissaos/" + vinculoGrupoPermissaoDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, vinculoGrupoPermissaoDTO.getId().toString()))
            .body(vinculoGrupoPermissaoDTO);
    }

    /**
     * {@code PUT  /vinculo-grupo-permissaos/:id} : Updates an existing vinculoGrupoPermissao.
     *
     * @param id the id of the vinculoGrupoPermissaoDTO to save.
     * @param vinculoGrupoPermissaoDTO the vinculoGrupoPermissaoDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated vinculoGrupoPermissaoDTO,
     * or with status {@code 400 (Bad Request)} if the vinculoGrupoPermissaoDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the vinculoGrupoPermissaoDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<VinculoGrupoPermissaoDTO> updateVinculoGrupoPermissao(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody VinculoGrupoPermissaoDTO vinculoGrupoPermissaoDTO
    ) throws URISyntaxException {
        log.debug("REST request to update VinculoGrupoPermissao : {}, {}", id, vinculoGrupoPermissaoDTO);
        if (vinculoGrupoPermissaoDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, vinculoGrupoPermissaoDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!vinculoGrupoPermissaoRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        vinculoGrupoPermissaoDTO = vinculoGrupoPermissaoService.update(vinculoGrupoPermissaoDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, vinculoGrupoPermissaoDTO.getId().toString()))
            .body(vinculoGrupoPermissaoDTO);
    }

    /**
     * {@code PATCH  /vinculo-grupo-permissaos/:id} : Partial updates given fields of an existing vinculoGrupoPermissao, field will ignore if it is null
     *
     * @param id the id of the vinculoGrupoPermissaoDTO to save.
     * @param vinculoGrupoPermissaoDTO the vinculoGrupoPermissaoDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated vinculoGrupoPermissaoDTO,
     * or with status {@code 400 (Bad Request)} if the vinculoGrupoPermissaoDTO is not valid,
     * or with status {@code 404 (Not Found)} if the vinculoGrupoPermissaoDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the vinculoGrupoPermissaoDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<VinculoGrupoPermissaoDTO> partialUpdateVinculoGrupoPermissao(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody VinculoGrupoPermissaoDTO vinculoGrupoPermissaoDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update VinculoGrupoPermissao partially : {}, {}", id, vinculoGrupoPermissaoDTO);
        if (vinculoGrupoPermissaoDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, vinculoGrupoPermissaoDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!vinculoGrupoPermissaoRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<VinculoGrupoPermissaoDTO> result = vinculoGrupoPermissaoService.partialUpdate(vinculoGrupoPermissaoDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, vinculoGrupoPermissaoDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /vinculo-grupo-permissaos} : get all the vinculoGrupoPermissaos.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of vinculoGrupoPermissaos in body.
     */
    @GetMapping("")
    public ResponseEntity<List<VinculoGrupoPermissaoDTO>> getAllVinculoGrupoPermissaos(
        VinculoGrupoPermissaoCriteria criteria,
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get VinculoGrupoPermissaos by criteria: {}", criteria);

        Page<VinculoGrupoPermissaoDTO> page = vinculoGrupoPermissaoQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /vinculo-grupo-permissaos/count} : count all the vinculoGrupoPermissaos.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/count")
    public ResponseEntity<Long> countVinculoGrupoPermissaos(VinculoGrupoPermissaoCriteria criteria) {
        log.debug("REST request to count VinculoGrupoPermissaos by criteria: {}", criteria);
        return ResponseEntity.ok().body(vinculoGrupoPermissaoQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /vinculo-grupo-permissaos/:id} : get the "id" vinculoGrupoPermissao.
     *
     * @param id the id of the vinculoGrupoPermissaoDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the vinculoGrupoPermissaoDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<VinculoGrupoPermissaoDTO> getVinculoGrupoPermissao(@PathVariable("id") Long id) {
        log.debug("REST request to get VinculoGrupoPermissao : {}", id);
        Optional<VinculoGrupoPermissaoDTO> vinculoGrupoPermissaoDTO = vinculoGrupoPermissaoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(vinculoGrupoPermissaoDTO);
    }

    /**
     * {@code DELETE  /vinculo-grupo-permissaos/:id} : delete the "id" vinculoGrupoPermissao.
     *
     * @param id the id of the vinculoGrupoPermissaoDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVinculoGrupoPermissao(@PathVariable("id") Long id) {
        log.debug("REST request to delete VinculoGrupoPermissao : {}", id);
        vinculoGrupoPermissaoService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
            .build();
    }
}
