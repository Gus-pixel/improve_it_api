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
        newPilar.setNome(data.nome());
        newPilar.setStatus(data.status());

        pilarRepository.save(newPilar);
        return newPilar;

    }

    public Pilar updatePilar(UUID uuid, PilarRequestDTO data){
        Pilar existingPilar = pilarRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Pilar não encontrado com o UUID!"+uuid));

        if (data.nome() != null){
            existingPilar.setNome(data.nome());
        }
        if (data.status() != null){
            existingPilar.setStatus(data.status());
        }

        return pilarRepository.save(existingPilar);
    }

    public List<Pilar> getPilares() { return pilarRepository.findAll();}

    public Pilar getPilarById(UUID uuid){
        return pilarRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Pilar com ID " + uuid + " não encontrado."));
    }
}
