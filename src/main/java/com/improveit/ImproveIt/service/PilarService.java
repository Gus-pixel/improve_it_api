package com.improveit.ImproveIt.service;

import com.improveit.ImproveIt.domain.pilar.Pilar;
import com.improveit.ImproveIt.domain.pilar.PilarRequestDTO;
import com.improveit.ImproveIt.repositories.PilarRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PilarService {
    @Autowired
    private PilarRepository pilarRepository;

    public Pilar createPilar(PilarRequestDTO data){
        Pilar newPilar = new Pilar();
        newPilar.setNome_pilar(data.nome_pilar());
        newPilar.setStatus_pilar(data.status_pilar());

        pilarRepository.save(newPilar);
        return newPilar;

    }

    public Pilar updatePilar(UUID uuid, PilarRequestDTO data){
        Pilar existingPilar = pilarRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Pilar não encontrado com o UUID!"+uuid));

        if (data.nome_pilar() != null){
            existingPilar.setNome_pilar(data.nome_pilar());
        }
        if (data.status_pilar() != null){
            existingPilar.setStatus_pilar(data.status_pilar());
        }

        return pilarRepository.save(existingPilar);
    }

    public List<Pilar> getPilares() { return pilarRepository.findAll();}

    public Pilar getPilarById(UUID uuid){
        return pilarRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Pilar com ID " + uuid + " não encontrado."));
    }
}
