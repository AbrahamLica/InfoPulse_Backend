package com.infopulse.web.rest.v1;

import com.infopulse.domain.User;
import com.infopulse.domain.Usuario;
import com.infopulse.repository.UsuarioRepository;
import com.infopulse.service.UserService;
import com.infopulse.service.UsernameAlreadyUsedException;
import com.infopulse.service.UsuarioQueryService;
import com.infopulse.service.UsuarioService;
import com.infopulse.service.dto.AdminUserDTO;
import com.infopulse.service.dto.UsuarioDTO;
import com.infopulse.web.rest.UsuarioResource;
import com.infopulse.web.rest.errors.BadRequestAlertException;
import jakarta.validation.Valid;
import java.net.URISyntaxException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UsuarioResourceExtended extends UsuarioResource {

    private static final String ENTITY_NAME = "TESTE";
    private final UserService userService;
    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;

    public UsuarioResourceExtended(
        UsuarioService usuarioService,
        UsuarioRepository usuarioRepository,
        UsuarioQueryService usuarioQueryService,
        UserService userService,
        PasswordEncoder passwordEncoder
    ) {
        super(usuarioService, usuarioRepository, usuarioQueryService);
        this.userService = userService;
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) throws URISyntaxException {
        if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
            throw new BadRequestAlertException("Senha não fornecida", ENTITY_NAME, "passwordmissing");
        }

        AdminUserDTO user = new AdminUserDTO();
        user.setActivated(true);
        user.setEmail(usuario.getEmail());
        user.setLogin(usuario.getLogin());
        user.setFirstName(usuario.getNome());
        user.setPassword(usuario.getSenha());

        var createdUser = userService.createUser(user);
        if (createdUser == null) {
            throw new BadRequestAlertException("Falha ao criar o usuário base", ENTITY_NAME, "usercreationfailed");
        }

        usuario.setLogin(createdUser.getLogin());
        usuario.setUser(createdUser);
        usuario.setSenha(createdUser.getPassword());
        usuario.setDataCadastro(Instant.now());
        usuario.setNome(createdUser.getFirstName());
        usuario.setAtivo(true);

        return super.createUsuario(usuario);
    }


    @Override
    public ResponseEntity<Usuario> updateUsuario(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody Usuario usuario
    ) throws URISyntaxException {
//        userService
//            .findOneByLogin(usuario.getEmail())
//            .ifPresent(existingUser -> {
//                if (!existingUser.getId().equals(usuario.getUser().getId())) {
//                    throw new UsernameAlreadyUsedException();
//                }
//            });

        AdminUserDTO jhiUser = new AdminUserDTO();
        jhiUser.setId(usuario.getUser().getId());



        jhiUser.setFirstName(usuario.getNome());
        jhiUser.setLastName(usuario.getNome());
        jhiUser.setActivated(Optional.ofNullable(usuario.getAtivo()).orElse(true));
        jhiUser.setEmail(usuario.getEmail());
        jhiUser.setLogin(usuario.getEmail());

//        if (usuario.getSenha() != null && !usuario.getSenha().isBlank()) {
//            jhiUser.setPassword(usuario.getSenha());
//        }

        userService.updateUser(jhiUser);

        return super.updateUsuario(id, usuario);
    }

    @Override
    public ResponseEntity<Usuario> partialUpdateUsuario(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody Usuario usuario
    ) throws URISyntaxException {

        AdminUserDTO jhiUser = new AdminUserDTO();
        jhiUser.setId(usuario.getUser().getId());
        jhiUser.setFirstName(usuario.getNome());
        jhiUser.setActivated(true);
        jhiUser.setEmail(usuario.getEmail());
        jhiUser.setLogin(usuario.getLogin());
        userService.updateUser(jhiUser);
        return super.partialUpdateUsuario(id, usuario);
    }




}
