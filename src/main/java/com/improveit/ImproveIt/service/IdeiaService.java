package com.improveit.ImproveIt.service;

import com.improveit.ImproveIt.domain.ideia.Ideia;
import com.improveit.ImproveIt.domain.ideia.IdeiaRequestDTO;
import com.improveit.ImproveIt.domain.usuario.Usuario;
import com.improveit.ImproveIt.repositories.IdeiaRepository;
import com.improveit.ImproveIt.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class IdeiaService {
    @Autowired
    private IdeiaRepository ideiaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Ideia createIdeia(IdeiaRequestDTO data){
        Ideia newIdeia = new Ideia();
        if(data.id_usuario() != null){
            Usuario existingUsuario = usuarioRepository.findById(data.id_usuario())
                    .orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado com o UUID: " + data.id_usuario()));
            newIdeia.setUsuario(existingUsuario);
        }
        newIdeia.setTitulo(data.titulo());
        newIdeia.setDesc_ideia(data.desc_ideia());
        newIdeia.setDesc_problema(data.desc_problema());
        newIdeia.setData_ideia(data.data_ideia());
        newIdeia.setStatus(data.status());

        ideiaRepository.save(newIdeia);
        return newIdeia;
    }

    public Ideia updateIdeia(UUID uuid, IdeiaRequestDTO data) {
        Ideia existingIdeia = ideiaRepository.findById(uuid).
                orElseThrow(() -> new EntityNotFoundException("Ideia não encontrado com o UUID: " + uuid));

        if (data.titulo() != null) {
            existingIdeia.setTitulo(data.titulo());
        }
        if (data.desc_ideia() != null) {
            existingIdeia.setDesc_ideia(data.desc_ideia());
        }
        if (data.desc_problema() != null) {
            existingIdeia.setDesc_problema(data.desc_problema());
        }
        if (data.data_ideia() != null) {
            existingIdeia.setData_ideia(data.data_ideia());
        }
        if (data.status() != null) {
            existingIdeia.setStatus(data.status());
        }
        if(data.id_usuario() != null){
            Usuario existingUsuario = usuarioRepository.findById(data.id_usuario())
                    .orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado com o UUID: " + data.id_usuario()));
            existingIdeia.setUsuario(existingUsuario);
        }

        return ideiaRepository.save(existingIdeia);
    }

    public List<Ideia> getIdeia() { return ideiaRepository.findAll();}

    public Ideia getIdeiaById(UUID uuid) {
        return ideiaRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Usuário com ID " + uuid + " não encontrado."));
    }
}
