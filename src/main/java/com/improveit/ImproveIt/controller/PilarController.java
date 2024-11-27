package com.improveit.ImproveIt.controller;

import com.improveit.ImproveIt.domain.pilar.Pilar;
import com.improveit.ImproveIt.domain.pilar.PilarRequestDTO;
import com.improveit.ImproveIt.service.PilarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/pilar")
public class PilarController {

    @Autowired
    private PilarService pilarService;

    @PostMapping
    public ResponseEntity<Pilar> create(@RequestBody PilarRequestDTO body) {
        Pilar newPilar = this.pilarService.createPilar(body);
        return ResponseEntity.ok(newPilar);
    }

    @PutMapping({"/{uuid}"})
    public ResponseEntity<Pilar> updatePilar(@PathVariable UUID uuid, @RequestBody PilarRequestDTO body) {
        Pilar updatedPilar = this.pilarService.updatePilar(uuid, body);
        return ResponseEntity.ok(updatedPilar);
    }

    @GetMapping
    public ResponseEntity<List<Pilar>> getPilares() {
        List<Pilar> pilares = this.pilarService.getPilares();
        return ResponseEntity.ok(pilares);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Pilar> getPilar(@PathVariable UUID uuid) {
        Pilar pilar = this.pilarService.getPilarById(uuid);
        return ResponseEntity.ok(pilar);
    }
}
