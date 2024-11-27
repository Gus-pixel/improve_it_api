package com.improveit.ImproveIt.controller;

import com.improveit.ImproveIt.domain.formulario.Questao;
import com.improveit.ImproveIt.domain.formulario.QuestaoRequestDTO;
import com.improveit.ImproveIt.service.QuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/questoes")
public class QuestaoController {

    @Autowired
    private QuestaoService questaoService;

    @PostMapping
    public ResponseEntity<Questao> salvarQuestao(@RequestBody QuestaoRequestDTO body) {
        Questao createdQuestao = questaoService.salvarQuestao(body);
        return ResponseEntity.ok(createdQuestao);
    }

    @GetMapping
    public ResponseEntity<List<Questao>> listarQuestoes() {
        List<Questao> questoes = questaoService.listarQuestoes();
        return ResponseEntity.ok(questoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Questao> obterQuestao(@PathVariable UUID id) {
        Questao questao = questaoService.obterQuestao(id);
        return ResponseEntity.ok(questao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirQuestao(@PathVariable UUID id) {
        questaoService.excluirQuestao(id);
        return ResponseEntity.noContent().build();
    }
}
