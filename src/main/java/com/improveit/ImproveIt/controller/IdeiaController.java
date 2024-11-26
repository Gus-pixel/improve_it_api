package com.improveit.ImproveIt.controller;

import com.improveit.ImproveIt.domain.ideia.Ideia;
import com.improveit.ImproveIt.domain.ideia.IdeiaRequestDTO;
import com.improveit.ImproveIt.domain.usuario.Usuario;
import com.improveit.ImproveIt.service.IdeiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ideia")
public class IdeiaController {

    @Autowired
    private IdeiaService ideiaService;

    @PostMapping
    public ResponseEntity<Ideia> create(@RequestBody IdeiaRequestDTO body) {
        Ideia newIdeia = this.ideiaService.createIdeia(body);
        return ResponseEntity.ok(newIdeia);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<Ideia> updateIdeia(@PathVariable UUID uuid, @RequestBody IdeiaRequestDTO body) {
        Ideia updatedIdeia = this.ideiaService.updateIdeia(uuid, body);
        return ResponseEntity.ok(updatedIdeia);
    }

    @GetMapping
    public ResponseEntity<List<Ideia>> getIdeias() {
        List<Ideia> ideias = this.ideiaService.getIdeia();
        return ResponseEntity.ok(ideias);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Ideia> getIdeia(@PathVariable UUID uuid) {
        Ideia ideia = this.ideiaService.getIdeiaById(uuid);
        return ResponseEntity.ok(ideia);
    }

}
