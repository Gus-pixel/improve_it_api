package com.improveit.ImproveIt.service;

import com.improveit.ImproveIt.domain.usuario.Usuario;
import com.improveit.ImproveIt.domain.usuario.UsuarioRequestDTO;
import com.improveit.ImproveIt.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario createUsuario(UsuarioRequestDTO data){
        Usuario newUsuario = new Usuario();
        newUsuario.setUsuario(data.usuario());
        newUsuario.setSenha(data.senha());
        newUsuario.setNome(data.nome());
        newUsuario.setStatus(data.status());
        newUsuario.setCargo(data.cargo());

        usuarioRepository.save(newUsuario);
        return newUsuario;
    }

    public Usuario updateUsuario(UUID uuid, UsuarioRequestDTO data) {
        Usuario existingUsuario = usuarioRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o UUID: " + uuid));

        if (data.usuario() != null) {
            existingUsuario.setUsuario(data.usuario());
        }
        if (data.senha() != null) {
            existingUsuario.setSenha(data.senha());
        }
        if (data.nome() != null) {
            existingUsuario.setNome(data.nome());
        }
        if (data.status() != null) {
            existingUsuario.setStatus(data.status());
        }
        if (data.cargo() != null) {
            existingUsuario.setCargo(data.cargo());
        }

        return usuarioRepository.save(existingUsuario);
    }


    public List<Usuario> getUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(UUID uuid) {
        return usuarioRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Usuário com ID " + uuid + " não encontrado."));
    }

}
