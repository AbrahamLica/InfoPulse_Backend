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
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UsuarioResourceExtended extends UsuarioResource {

    private static final String ENTITY_NAME = "TESTE";
    private final UserService userService;
    private final UsuarioService usuarioService;

    public UsuarioResourceExtended(
        UsuarioService usuarioService,
        UsuarioRepository usuarioRepository,
        UsuarioQueryService usuarioQueryService,
        UserService userService
    ) {
        super(usuarioService, usuarioRepository, usuarioQueryService);
        this.userService = userService;
        this.usuarioService = usuarioService;
    }

    @Override
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) throws URISyntaxException {
        //        userService.findOneByLogin(usuarioDTO.getEmail())
        //            .ifPresent(existingUser -> {
        //                throw new UsernameAlreadyUsedException();
        //            });

        AdminUserDTO user = new AdminUserDTO();
        user.setActivated(true);
        user.setEmail(usuario.getEmail());
        user.setLogin(usuario.getEmail());
        user.setFirstName(usuario.getNome());
        user.setPassword(usuario.getSenha());

        var createdUser = userService.createUser(user);
        if (createdUser == null) {
            throw new BadRequestAlertException("Falha ao criar o usuário base", ENTITY_NAME, "usercreationfailed");
        }

        usuario.setUser(createdUser);

        //        usuario.setSenha(null);

        return super.createUsuario(usuario);
    }

    @Override
    public ResponseEntity<Usuario> updateUsuario(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody Usuario usuario
    ) throws URISyntaxException {
        userService
            .findOneByLogin(usuario.getEmail())
            .ifPresent(existingUser -> {
                if (!existingUser.getId().equals(usuario.getUser().getId())) {
                    throw new UsernameAlreadyUsedException();
                }
            });

        AdminUserDTO jhiUser = new AdminUserDTO();
        jhiUser.setId(usuario.getUser().getId());
        jhiUser.setFirstName(usuario.getNome());
        jhiUser.setLastName(usuario.getNome());
        jhiUser.setActivated(Optional.ofNullable(usuario.getAtivo()).orElse(true));
        jhiUser.setEmail(usuario.getEmail());
        jhiUser.setLogin(usuario.getEmail());

        if (usuario.getSenha() != null && !usuario.getSenha().isBlank()) {
            jhiUser.setPassword(usuario.getSenha());
        }

        userService.updateUser(jhiUser);
        //        usuario.setSenha(null);

        return super.updateUsuario(id, usuario);
    }
}
