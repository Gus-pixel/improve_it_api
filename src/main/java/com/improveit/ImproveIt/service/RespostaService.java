package com.improveit.ImproveIt.service;

import com.improveit.ImproveIt.domain.formulario.Questao;
import com.improveit.ImproveIt.domain.resposta.Resposta;
import com.improveit.ImproveIt.domain.resposta.RespostaRequestDTO;
import com.improveit.ImproveIt.repositories.QuestaoRepository;
import com.improveit.ImproveIt.repositories.RespostaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RespostaService {
    @Autowired
    private RespostaRepository respostaRepository;
    @Autowired
    private QuestaoRepository questaoRepository;

    public Resposta createResposta(RespostaRequestDTO data) {
        Resposta newResposta = new Resposta();
        if(data.id_questao() != null){
            Questao existingQuestao = questaoRepository.findById(data.id_questao())
                    .orElseThrow(()-> new EntityNotFoundException("Questão não encontrada " + data.id_questao()));
        }
        newResposta.setNota(data.nota());

        respostaRepository.save(newResposta);
        return newResposta;
    }

    public Resposta updateResposta(UUID uuid, RespostaRequestDTO data) {
        Resposta existingResposta = respostaRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Resposta não encontrada com o UUID " + uuid));
        if (data.nota() != null) {
            existingResposta.setNota(data.nota());
        }
        if(data.id_questao() != null){
            Questao existingQuestao = questaoRepository.findById(data.id_questao())
                    .orElseThrow(() -> new EntityNotFoundException("Questão não encontrada com o UUID " + data.id_questao() ));
            existingResposta.setQuestao(existingQuestao);
        }
        return respostaRepository.save(existingResposta);
    }
    public List<Resposta> getResposta(){ return respostaRepository.findAll();}

    public Resposta getRespostaById(UUID uuid) {
        return respostaRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Resposta com ID"  + uuid + "não encontrada."));
    }

}
