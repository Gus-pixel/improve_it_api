package com.improveit.ImproveIt.service;

import com.improveit.ImproveIt.domain.formulario.Formulario;
import com.improveit.ImproveIt.domain.formulario.FormularioRequestDTO;
import com.improveit.ImproveIt.domain.formulario.Questao;
import com.improveit.ImproveIt.domain.resposta.Resposta;

import com.improveit.ImproveIt.domain.resposta.RespostaRequestDTO;
import com.improveit.ImproveIt.domain.setor.Setor;
import com.improveit.ImproveIt.domain.usuario.Usuario;
import com.improveit.ImproveIt.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FormularioService {

    @Autowired
    private FormularioRepository formularioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SetorRepository setorRepository;

    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private QuestaoRepository questaoRepository;

    // Salvar um novo formulário
    public Formulario salvarFormulario(FormularioRequestDTO data) {
        Formulario newFormulario = new Formulario();

        if(data.id_setor() != null){
            Setor existingSetor = setorRepository.findById(data.id_setor()).
                    orElseThrow(() -> new EntityNotFoundException("Setor não encontrado com o UUID: " + data.id_setor()));
            newFormulario.setSetor(existingSetor);
        }

        newFormulario.setTitulo(data.titulo());
        newFormulario.setStatus(data.status());
        newFormulario.setDataCriacao(data.dataCriacao());

        formularioRepository.save(newFormulario);

        List<Resposta> respostas = new ArrayList<>();

        for (RespostaRequestDTO respostaDTO : data.respostas()) {
            // Validar se a questão existe
            Questao questao = questaoRepository.findById(respostaDTO.id_questao())
                    .orElseThrow(() -> new EntityNotFoundException("Questão não encontrada com o UUID: " + respostaDTO.id_questao()));

            // Criar a resposta e associar
            Resposta resposta = new Resposta();
            resposta.setNota(respostaDTO.nota());
            resposta.setQuestao(questao);

            // Adicionar à lista
            respostas.add(resposta);
        }

// Salvar todas as respostas de uma vez
        respostaRepository.saveAll(respostas);

// Salvar todas as respostas de uma vez
        respostaRepository.saveAll(respostas);

        return newFormulario;
    }

    // Listar todos os formulários
    public List<Formulario> listarFormularios() {
        return formularioRepository.findAll();
    }

    // Obter formulário por ID
    public Formulario obterFormulario(UUID id) {
        return formularioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Formulário com ID " + id + " não encontrado."));
    }

    // Atualizar um formulário existente
    public Formulario atualizarFormulario(UUID id, FormularioRequestDTO data) {
        Formulario formularioExistente = formularioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Formulário com ID " + id + " não encontrado."));

        if(data.id_setor() != null){
            Setor existingSetor = setorRepository.findById(data.id_setor()).
                    orElseThrow(() -> new EntityNotFoundException("Setor não encontrado com o UUID: " + data.id_setor()));
            formularioExistente.setSetor(existingSetor);
        }

        formularioExistente.setTitulo(data.titulo());
        formularioExistente.setStatus(data.status());
        formularioExistente.setDataCriacao(data.dataCriacao());

        formularioRepository.save(formularioExistente);
        return formularioExistente;
    }

    // Deletar um formulário
    public boolean deletarFormulario(UUID id) {
        if (!formularioRepository.existsById(id)) {
            throw new EntityNotFoundException("Formulário com ID " + id + " não encontrado.");
        }
        formularioRepository.deleteById(id);
        return false;
    }
}
