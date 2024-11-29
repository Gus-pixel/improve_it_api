package com.improveit.ImproveIt.controller;


import com.improveit.ImproveIt.domain.usuario.LoginRequestDTO;
import com.improveit.ImproveIt.domain.usuario.Usuario;
import com.improveit.ImproveIt.service.UsuarioService;
import com.improveit.ImproveIt.utils.CredenciaisInvalidasException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody LoginRequestDTO data) {
        try {
            Usuario usuario = usuarioService.login(data);
            return ResponseEntity.ok(usuario);
        } catch (CredenciaisInvalidasException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
