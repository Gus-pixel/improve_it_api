package com.improveit.ImproveIt.service;

import com.improveit.ImproveIt.domain.formulario.Formulario;
import com.improveit.ImproveIt.repositories.FormularioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FormularioService {

    private final FormularioRepository formularioRepository;

    public FormularioService(FormularioRepository formularioRepository) {
        this.formularioRepository = formularioRepository;
    }

    // Converte FormularioDTO para Formulario (Entidade)
    private Formulario converterParaEntidade(FormularioDTO formularioDTO) {
        return new Formulario(
                formularioDTO.getId(),
                formularioDTO.getTitulo(),
                formularioDTO.getUsuario(),
                formularioDTO.getSetor(),
                formularioDTO.getDataCriacao(),
                formularioDTO.getStatus(),
                formularioDTO.getQuestoes().stream()
                        .map(questaoDTO -> new Questao(questaoDTO.getId(), questaoDTO.getDescricao(), questaoDTO.getTipo()))
                        .collect(Collectors.toList())
        );
    }

    // Converte Formulario (Entidade) para FormularioDTO
    private FormularioDTO converterParaDTO(Formulario formulario) {
        return new FormularioDTO(
                formulario.getId(),
                formulario.getTitulo(),
                formulario.getUsuario(),
                formulario.getSetor(),
                formulario.getDataCriacao(),
                formulario.getStatus(),
                formulario.getQuestoes().stream()
                        .map(questao -> new QuestaoDTO(questao.getId(), questao.getDescricao(), questao.getTipo()))
                        .collect(Collectors.toList())
        );
    }

    // Salvar um novo formulário
    @Transactional
    public FormularioDTO salvarFormulario(FormularioDTO formularioDTO) {
        Formulario formulario = converterParaEntidade(formularioDTO);
        Formulario formularioSalvo = formularioRepository.save(formulario);
        return converterParaDTO(formularioSalvo);
    }

    // Obter formulário por ID
    public FormularioDTO buscarPorId(UUID id) {
        Formulario formulario = formularioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Formulário não encontrado"));
        return converterParaDTO(formulario);
    }

    // Listar todos os formulários
    public List<FormularioDTO> listarTodos() {
        List<Formulario> formularios = formularioRepository.findAll();
        return formularios.stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    // Atualizar um formulário existente
    @Transactional
    public FormularioDTO atualizarFormulario(UUID id, FormularioDTO formularioDTO) {
        Optional<Formulario> formularioExistente = formularioRepository.findById(id);

        if (formularioExistente.isEmpty()) {
            throw new RuntimeException("Formulário não encontrado");
        }

        Formulario formulario = formularioExistente.get();
        formulario.setTitulo(formularioDTO.getTitulo());
        formulario.setUsuario(formularioDTO.getUsuario());
        formulario.setSetor(formularioDTO.getSetor());
        formulario.setStatus(formularioDTO.getStatus());
        formulario.setQuestoes(formularioDTO.getQuestoes().stream()
                .map(questaoDTO -> new Questao(questaoDTO.getId(), questaoDTO.getDescricao(), questaoDTO.getTipo()))
                .collect(Collectors.toList()));

        // Atualiza o formulário no banco de dados
        Formulario formularioAtualizado = formularioRepository.save(formulario);
        return converterParaDTO(formularioAtualizado);
    }

    // Deletar um formulário
    @Transactional
    public void deletarFormulario(UUID id) {
        if (!formularioRepository.existsById(id)) {
            throw new RuntimeException("Formulário não encontrado");
        }
        formularioRepository.deleteById(id);
    }
}
