package com.improveit.ImproveIt.controller;

import com.improveit.ImproveIt.domain.formulario.Formulario;
import com.improveit.ImproveIt.service.FormularioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/formularios")
public class FormularioController {

    private final FormularioService formularioService;

    public FormularioController(FormularioService formularioService) {
        this.formularioService = formularioService;
    }

    // Criar um novo formulário
    @PostMapping
    public ResponseEntity<Formulario> criarFormulario(@Valid @RequestBody Formulario formulario) {
        Formulario novoFormulario = formularioService.salvarFormulario(formulario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFormulario);
    }

    // Obter um formulário por ID
    @GetMapping("/{id}")
    public ResponseEntity<Formulario> obterFormularioPorId(@PathVariable UUID id) {
        Formulario formulario = formularioService.buscarPorId(id);
        if (formulario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(formulario);
    }

    // Listar todos os formulários
    @GetMapping
    public ResponseEntity<List<Formulario>> listarFormularios() {
        List<Formulario> formularios = formularioService.listarTodos();
        return ResponseEntity.ok(formularios);
    }

    // Atualizar um formulário existente
    @PutMapping("/{id}")
    public ResponseEntity<Formulario> atualizarFormulario(
            @PathVariable UUID id,
            @Valid @RequestBody Formulario formularioAtualizado
    ) {
        if (!id.equals(formularioAtualizado.getId())) {
            return ResponseEntity.badRequest().build();
        }

        Formulario formulario = formularioService.atualizarFormulario(id, formularioAtualizado);
        if (formulario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(formulario);
    }

    // Deletar um formulário
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFormulario(@PathVariable UUID id) {
        boolean deleted = formularioService.deletarFormulario(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
