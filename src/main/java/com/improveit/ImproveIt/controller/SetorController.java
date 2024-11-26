package com.improveit.ImproveIt.controller;

import com.improveit.ImproveIt.domain.setor.Setor;
import com.improveit.ImproveIt.domain.setor.SetorRequestDTO;
import com.improveit.ImproveIt.service.SetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/setor")
public class SetorController {
    @Autowired
    private SetorService setorService;

    @PostMapping
    public ResponseEntity<Setor> create(@RequestBody SetorRequestDTO body) {
        Setor setor = this.setorService.createSetor(body);
        return ResponseEntity.ok(setor);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<Setor> updateSetor(@PathVariable UUID uuid, @RequestBody SetorRequestDTO body) {
        Setor updatedSetor = this.setorService.updateSetor(uuid, body);
        return ResponseEntity.ok(updatedSetor);
    }

    @GetMapping
    public ResponseEntity<List<Setor>> getSetores(){
        List<Setor> setores = this.setorService.getSetores();
        return ResponseEntity.ok(setores);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Setor> getSetores(@PathVariable UUID uuid) {
        Setor setor = this.setorService.getSetorById(uuid);
        return ResponseEntity.ok(setor);
    }

}
