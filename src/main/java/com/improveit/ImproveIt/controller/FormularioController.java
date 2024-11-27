package com.improveit.ImproveIt.controller;

import com.improveit.ImproveIt.domain.formulario.Formulario;
import com.improveit.ImproveIt.domain.formulario.FormularioRequestDTO;
import com.improveit.ImproveIt.service.FormularioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/formularios")
public class FormularioController {

    @Autowired
    private FormularioService formularioService;

    // Criar um novo formulário
    @PostMapping
    public ResponseEntity<Formulario> criarFormulario(@RequestBody FormularioRequestDTO body) {
        Formulario novoFormulario = this.formularioService.salvarFormulario(body);
        return ResponseEntity.ok(novoFormulario);
    }

    // Atualizar um formulário existente
    @PutMapping("/{uuid}")
    public ResponseEntity<Formulario> atualizarFormulario(
            @PathVariable UUID uuid,
            @RequestBody FormularioRequestDTO body
    ) {
        Formulario formulario = this.formularioService.atualizarFormulario(uuid, body);
        return ResponseEntity.ok(formulario);
    }

    // Listar todos os formulários
    @GetMapping
    public ResponseEntity<List<Formulario>> listarFormularios() {
        List<Formulario> formularios = formularioService.listarFormularios();
        return ResponseEntity.ok(formularios);
    }

    // Obter um formulário por ID
    @GetMapping("/{uuid}")
    public ResponseEntity<Formulario> obterFormularioPorId(@PathVariable UUID uuid) {
        Formulario formulario = formularioService.obterFormulario(uuid);
        return ResponseEntity.ok(formulario);
    }

    // Deletar um formulário
    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deletarFormulario(@PathVariable UUID uuid) {
        boolean deleted = formularioService.deletarFormulario(uuid);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
