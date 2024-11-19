package com.improveit.ImproveIt.service;

import com.improveit.ImproveIt.domain.usuario.Usuario;
import com.improveit.ImproveIt.domain.usuario.UsuarioRequestDTO;
import com.improveit.ImproveIt.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public Usuario createUsuario(UsuarioRequestDTO data){
        Usuario newUsuario = new Usuario();
        newUsuario.setUsername(data.username());
        newUsuario.setSenha(data.senha());
        newUsuario.setNome(data.nome());
        newUsuario.setStatus(data.status());
        newUsuario.setCargo(data.cargo());

        repository.save(newUsuario);
        return newUsuario;
    }
}
