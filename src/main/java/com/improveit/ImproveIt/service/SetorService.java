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
        newSetor.setNome(data.nome());
        newSetor.setStatus(data.status());

        setorRepository.save(newSetor);
        return newSetor;
    }

    public Setor updateSetor(UUID uuid, SetorRequestDTO data) {
        Setor existingSetor = setorRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Setor não encontrado com o UUID: " + uuid));

        if (data.nome() != null) {
            existingSetor.setNome(data.nome());
        }
        if(data.status() != null) {
            existingSetor.setStatus(data.status());
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

