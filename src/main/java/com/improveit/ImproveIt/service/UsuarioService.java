package com.improveit.ImproveIt.service;

import com.improveit.ImproveIt.domain.setor.Setor;
import com.improveit.ImproveIt.domain.usuario.LoginRequestDTO;
import com.improveit.ImproveIt.domain.usuario.Usuario;
import com.improveit.ImproveIt.domain.usuario.UsuarioRequestDTO;
import com.improveit.ImproveIt.repositories.SetorRepository;
import com.improveit.ImproveIt.repositories.UsuarioRepository;
import com.improveit.ImproveIt.utils.CredenciaisInvalidasException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SetorRepository setorRepository;

    public Usuario createUsuario(UsuarioRequestDTO data){
        Usuario newUsuario = new Usuario();
        if(data.id_setor() != null){
            Setor existingSetor = setorRepository.findById(data.id_setor())
                    .orElseThrow(() -> new EntityNotFoundException("Setor não encontrado com o UUID: " + data.id_setor()));
            newUsuario.setSetor(existingSetor);
        }
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

        if(data.id_setor() != null){
            Setor existingSetor = setorRepository.findById(data.id_setor())
                    .orElseThrow(() -> new EntityNotFoundException("Setor não encontrado com o UUID: " + data.id_setor()));
            existingUsuario.setSetor(existingSetor);
        }

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

    public Usuario login(LoginRequestDTO data) {
        return usuarioRepository.findByUsuario(data.usuario())
                .filter(u -> u.getSenha().equals(data.senha()))
                .orElseThrow(() -> new CredenciaisInvalidasException("Usuário ou senha incorretos"));
    }

}
