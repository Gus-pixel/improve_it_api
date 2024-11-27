package com.improveit.ImproveIt.service;

import com.improveit.ImproveIt.domain.melhoria.Melhoria;
import com.improveit.ImproveIt.domain.melhoria.MelhoriaRequestDTO;
import com.improveit.ImproveIt.domain.usuario.Usuario;
import com.improveit.ImproveIt.repositories.MelhoriaRepository;
import com.improveit.ImproveIt.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MelhoriaService {
    @Autowired
    private MelhoriaRepository melhoriaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Melhoria create(MelhoriaRequestDTO data){
        Melhoria newMelhoria = new Melhoria();
        if(data.id_usuario() != null){
            Usuario existingUsuario = usuarioRepository.findById(data.id_usuario())
                    .orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado com o UUID: " + data.id_usuario()));
            newMelhoria.setUsuario(existingUsuario);
        }
        newMelhoria.setDesc_problema(data.desc_problema());
        newMelhoria.setData(data.data());
        newMelhoria.setStatus(data.status());

        melhoriaRepository.save(newMelhoria);
        return newMelhoria;
    }

    public Melhoria update(UUID uuid, MelhoriaRequestDTO data) {
        Melhoria existingMelhoria = melhoriaRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Ideia não encontrado com o UUID: " + uuid));

        if (data.desc_problema() != null) {
            existingMelhoria.setDesc_problema(data.desc_problema());
        }
        if (data.data() != null) {
            existingMelhoria.setData(data.data());
        }
        if (data.status() != null) {
            existingMelhoria.setStatus(data.status());
        }
        if(data.id_usuario() != null){
            Usuario existingUsuario = usuarioRepository.findById(data.id_usuario())
                    .orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado com o UUID: " + data.id_usuario()));
            existingMelhoria.setUsuario(existingUsuario);
        }

        return melhoriaRepository.save(existingMelhoria);
    }

    public List<Melhoria> get() { return melhoriaRepository.findAll();}

    public Melhoria getById(UUID uuid) {
        return melhoriaRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Usuário com ID " + uuid + " não encontrado."));
    }
}
