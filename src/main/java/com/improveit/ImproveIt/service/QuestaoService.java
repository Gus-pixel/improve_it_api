package com.improveit.ImproveIt.service;

import com.improveit.ImproveIt.domain.formulario.Formulario;
import com.improveit.ImproveIt.domain.formulario.Questao;
import com.improveit.ImproveIt.domain.formulario.QuestaoRequestDTO;
import com.improveit.ImproveIt.repositories.FormularioRepository;
import com.improveit.ImproveIt.repositories.QuestaoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class QuestaoService {

    @Autowired
    private QuestaoRepository questaoRepository;

    @Autowired
    private FormularioRepository formularioRepository;

    public Questao salvarQuestao(@Valid QuestaoRequestDTO data) {
        Questao newQuestao = new Questao();
        if(data.id_formulario() != null){
            Formulario existingFormulario = formularioRepository.findById(data.id_formulario())
                    .orElseThrow(() -> new EntityNotFoundException("Formulário não encontrado com o UUID: " + data.id_formulario()));
            newQuestao.setFormulario(existingFormulario);
        }
        newQuestao.setTexto_pergunta(data.texto_pergunta());
        newQuestao.setNota(data.nota());

        questaoRepository.save(newQuestao);
        return newQuestao;
    }

    public List<Questao> listarQuestoes() {
        return questaoRepository.findAll();
    }

    public Questao obterQuestao(UUID uuid) {
        return questaoRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Questão com ID " + uuid + " não encontrado."));
    }

    public void excluirQuestao(UUID id) {
        questaoRepository.deleteById(id);
    }
}
