package com.improveit.ImproveIt.controller;

import com.improveit.ImproveIt.domain.melhoria.Melhoria;
import com.improveit.ImproveIt.domain.melhoria.MelhoriaRequestDTO;
import com.improveit.ImproveIt.service.MelhoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/ideia")
public class MelhoriaController {

    @Autowired
    private MelhoriaService melhoriaService;

    @PostMapping
    public ResponseEntity<Melhoria> create(@RequestBody MelhoriaRequestDTO body) {
        Melhoria newMelhoria = this.melhoriaService.create(body);
        return ResponseEntity.ok(newMelhoria);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<Melhoria> update(@PathVariable UUID uuid, @RequestBody MelhoriaRequestDTO body) {
        Melhoria updatedMelhoria = this.melhoriaService.update(uuid, body);
        return ResponseEntity.ok(updatedMelhoria);
    }

    @GetMapping
    public ResponseEntity<List<Melhoria>> getMelhorias() {
        List<Melhoria> Melhorias = this.melhoriaService.get();
        return ResponseEntity.ok(Melhorias);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Melhoria> getMelhoria(@PathVariable UUID uuid) {
        Melhoria melhoria = this.melhoriaService.getById(uuid);
        return ResponseEntity.ok(melhoria);
    }

}
