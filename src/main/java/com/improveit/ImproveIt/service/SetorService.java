package com.improveit.ImproveIt.service;

import com.improveit.ImproveIt.domain.setor.Setor;
import com.improveit.ImproveIt.domain.setor.SetorRequestDTO;
import com.improveit.ImproveIt.repositories.SetorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SetorService {

    @Autowired
    private SetorRepository setorRepository;


    public Setor createSetor(SetorRequestDTO data) {
        Setor newSetor = new Setor();
        newSetor.setId_setor(data.id());
        newSetor.setNome_setor(data.nome_setor());

        setorRepository.save(newSetor);
        return newSetor;
    }

    public Setor updateSetor(UUID uuid, SetorRequestDTO data) {
        Setor existingSetor = setorRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Setor não encontrado com o UUID: " + uuid));

        if (data.nome_setor() != null) {
            existingSetor.setNome_setor(data.nome_setor());
        }

        return setorRepository.save(existingSetor);
    }

    public List<Setor> getSetores(){
        return setorRepository.findAll();
    }
    public Setor getSetorById(UUID id) {
        return setorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException
                ("Setor com o ID " + id + " não encontrado."));
    }

}

