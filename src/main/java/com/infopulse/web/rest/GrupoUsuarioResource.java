package com.infopulse.web.rest;

import com.infopulse.repository.GrupoUsuarioRepository;
import com.infopulse.service.GrupoUsuarioQueryService;
import com.infopulse.service.GrupoUsuarioService;
import com.infopulse.service.criteria.GrupoUsuarioCriteria;
import com.infopulse.service.dto.GrupoUsuarioDTO;
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
 * REST controller for managing {@link com.infopulse.domain.GrupoUsuario}.
 */
@RestController
@RequestMapping("/api/grupo-usuarios")
public class GrupoUsuarioResource {

    private static final Logger log = LoggerFactory.getLogger(GrupoUsuarioResource.class);

    private static final String ENTITY_NAME = "grupoUsuario";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final GrupoUsuarioService grupoUsuarioService;

    private final GrupoUsuarioRepository grupoUsuarioRepository;

    private final GrupoUsuarioQueryService grupoUsuarioQueryService;

    public GrupoUsuarioResource(
        GrupoUsuarioService grupoUsuarioService,
        GrupoUsuarioRepository grupoUsuarioRepository,
        GrupoUsuarioQueryService grupoUsuarioQueryService
    ) {
        this.grupoUsuarioService = grupoUsuarioService;
        this.grupoUsuarioRepository = grupoUsuarioRepository;
        this.grupoUsuarioQueryService = grupoUsuarioQueryService;
    }

    /**
     * {@code POST  /grupo-usuarios} : Create a new grupoUsuario.
     *
     * @param grupoUsuarioDTO the grupoUsuarioDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new grupoUsuarioDTO, or with status {@code 400 (Bad Request)} if the grupoUsuario has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<GrupoUsuarioDTO> createGrupoUsuario(@Valid @RequestBody GrupoUsuarioDTO grupoUsuarioDTO)
        throws URISyntaxException {
        log.debug("REST request to save GrupoUsuario : {}", grupoUsuarioDTO);
        if (grupoUsuarioDTO.getId() != null) {
            throw new BadRequestAlertException("A new grupoUsuario cannot already have an ID", ENTITY_NAME, "idexists");
        }
        grupoUsuarioDTO = grupoUsuarioService.save(grupoUsuarioDTO);
        return ResponseEntity.created(new URI("/api/grupo-usuarios/" + grupoUsuarioDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, grupoUsuarioDTO.getId().toString()))
            .body(grupoUsuarioDTO);
    }

    /**
     * {@code PUT  /grupo-usuarios/:id} : Updates an existing grupoUsuario.
     *
     * @param id the id of the grupoUsuarioDTO to save.
     * @param grupoUsuarioDTO the grupoUsuarioDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated grupoUsuarioDTO,
     * or with status {@code 400 (Bad Request)} if the grupoUsuarioDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the grupoUsuarioDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<GrupoUsuarioDTO> updateGrupoUsuario(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody GrupoUsuarioDTO grupoUsuarioDTO
    ) throws URISyntaxException {
        log.debug("REST request to update GrupoUsuario : {}, {}", id, grupoUsuarioDTO);
        if (grupoUsuarioDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, grupoUsuarioDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!grupoUsuarioRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        grupoUsuarioDTO = grupoUsuarioService.update(grupoUsuarioDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, grupoUsuarioDTO.getId().toString()))
            .body(grupoUsuarioDTO);
    }

    /**
     * {@code PATCH  /grupo-usuarios/:id} : Partial updates given fields of an existing grupoUsuario, field will ignore if it is null
     *
     * @param id the id of the grupoUsuarioDTO to save.
     * @param grupoUsuarioDTO the grupoUsuarioDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated grupoUsuarioDTO,
     * or with status {@code 400 (Bad Request)} if the grupoUsuarioDTO is not valid,
     * or with status {@code 404 (Not Found)} if the grupoUsuarioDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the grupoUsuarioDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<GrupoUsuarioDTO> partialUpdateGrupoUsuario(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody GrupoUsuarioDTO grupoUsuarioDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update GrupoUsuario partially : {}, {}", id, grupoUsuarioDTO);
        if (grupoUsuarioDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, grupoUsuarioDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!grupoUsuarioRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<GrupoUsuarioDTO> result = grupoUsuarioService.partialUpdate(grupoUsuarioDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, grupoUsuarioDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /grupo-usuarios} : get all the grupoUsuarios.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of grupoUsuarios in body.
     */
    @GetMapping("")
    public ResponseEntity<List<GrupoUsuarioDTO>> getAllGrupoUsuarios(
        GrupoUsuarioCriteria criteria,
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get GrupoUsuarios by criteria: {}", criteria);

        Page<GrupoUsuarioDTO> page = grupoUsuarioQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /grupo-usuarios/count} : count all the grupoUsuarios.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/count")
    public ResponseEntity<Long> countGrupoUsuarios(GrupoUsuarioCriteria criteria) {
        log.debug("REST request to count GrupoUsuarios by criteria: {}", criteria);
        return ResponseEntity.ok().body(grupoUsuarioQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /grupo-usuarios/:id} : get the "id" grupoUsuario.
     *
     * @param id the id of the grupoUsuarioDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the grupoUsuarioDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<GrupoUsuarioDTO> getGrupoUsuario(@PathVariable("id") Long id) {
        log.debug("REST request to get GrupoUsuario : {}", id);
        Optional<GrupoUsuarioDTO> grupoUsuarioDTO = grupoUsuarioService.findOne(id);
        return ResponseUtil.wrapOrNotFound(grupoUsuarioDTO);
    }

    /**
     * {@code DELETE  /grupo-usuarios/:id} : delete the "id" grupoUsuario.
     *
     * @param id the id of the grupoUsuarioDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrupoUsuario(@PathVariable("id") Long id) {
        log.debug("REST request to delete GrupoUsuario : {}", id);
        grupoUsuarioService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
            .build();
    }
}
