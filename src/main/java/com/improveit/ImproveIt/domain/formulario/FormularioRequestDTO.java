package com.improveit.ImproveIt.domain.formulario;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record FormularioRequestDTO(String titulo, String setor, LocalDateTime dataCriacao, Boolean status, UUID id_usuario, List<Questao>) {
}
