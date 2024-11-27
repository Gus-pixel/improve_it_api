package com.improveit.ImproveIt.service;

import com.improveit.ImproveIt.domain.formulario.Formulario;
import com.improveit.ImproveIt.repositories.FormularioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FormularioService {

    @Autowired
    private FormularioRepository formularioRepository;

    // Salvar um novo formulário
    public Formulario salvarFormulario(Formulario formulario) {
        return formularioRepository.save(formulario);
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
    public Formulario atualizarFormulario(UUID id, Formulario formulario) {
        Formulario formularioExistente = formularioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Formulário com ID " + id + " não encontrado."));

        formularioExistente.setTitulo(formulario.getTitulo());
        formularioExistente.setUsuario(formulario.getUsuario());
        formularioExistente.setSetor(formulario.getSetor());
        formularioExistente.setStatus(formulario.getStatus());
        formularioExistente.setQuestoes(formulario.getQuestoes());

        return formularioRepository.save(formularioExistente);
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
