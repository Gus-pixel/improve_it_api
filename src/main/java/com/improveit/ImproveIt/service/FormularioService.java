package com.improveit.ImproveIt.service;

import com.improveit.ImproveIt.domain.formulario.Formulario;
import com.improveit.ImproveIt.domain.formulario.FormularioRequestDTO;
import com.improveit.ImproveIt.domain.setor.Setor;
import com.improveit.ImproveIt.domain.usuario.Usuario;
import com.improveit.ImproveIt.repositories.FormularioRepository;
import com.improveit.ImproveIt.repositories.SetorRepository;
import com.improveit.ImproveIt.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    // Salvar um novo formulário
    public Formulario salvarFormulario(FormularioRequestDTO data) {
        Formulario newFormulario = new Formulario();
        if(data.id_usuario() != null){
            Usuario existingUsuario = usuarioRepository.findById(data.id_usuario()).
                    orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o UUID: " + data.id_usuario()));
            newFormulario.setUsuario(existingUsuario);
        }

        if(data.id_setor() != null){
            Setor existingSetor = setorRepository.findById(data.id_setor()).
                    orElseThrow(() -> new EntityNotFoundException("Setor não encontrado com o UUID: " + data.id_setor()));
            newFormulario.setSetor(existingSetor);
        }

        newFormulario.setTitulo(data.titulo());
        newFormulario.setStatus(data.status());
        newFormulario.setDataCriacao(data.dataCriacao());

        formularioRepository.save(newFormulario);
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

        if(data.id_usuario() != null){
            Usuario existingUsuario = usuarioRepository.findById(data.id_usuario()).
                    orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o UUID: " + data.id_usuario()));
            formularioExistente.setUsuario(existingUsuario);
        }

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
