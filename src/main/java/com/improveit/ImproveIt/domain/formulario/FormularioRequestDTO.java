package com.improveit.ImproveIt.domain.formulario;

import com.improveit.ImproveIt.domain.resposta.RespostaRequestDTO;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public record FormularioRequestDTO (String titulo, UUID id_setor, Date dataCriacao, Boolean status, List<Questao> questoes, List<RespostaRequestDTO> respostas) {
}
