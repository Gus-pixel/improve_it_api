package com.improveit.ImproveIt.domain.formulario;

import java.util.UUID;

public record QuestaoRequestDTO(String texto_pergunta, UUID id_formulario, Integer nota) {
}
