package com.improveit.ImproveIt.controller;

import com.improveit.ImproveIt.domain.usuario.LoginRequestDTO;
import com.improveit.ImproveIt.domain.usuario.Usuario;
import com.improveit.ImproveIt.domain.usuario.UsuarioRequestDTO;
import com.improveit.ImproveIt.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody UsuarioRequestDTO body){
        Usuario newUsuario = this.usuarioService.createUsuario(body);
        return ResponseEntity.ok(newUsuario);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable UUID uuid, @RequestBody UsuarioRequestDTO body) {
        Usuario updatedUsuario = this.usuarioService.updateUsuario(uuid, body);
        return ResponseEntity.ok(updatedUsuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios() {
        List<Usuario> usuarios = this.usuarioService.getUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable UUID uuid) {
        Usuario usuario = this.usuarioService.getUsuarioById(uuid);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/usuario")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO body) {
        Usuario usuario = usuarioService.login(body.usuario(), body.senha());

        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(401).body("Credenciais inválidas");
        }
    }
}


