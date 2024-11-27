package com.improveit.ImproveIt.domain.ideia;

import java.util.Date;
import java.util.UUID;

public record IdeiaRequestDTO(String titulo, String desc_ideia, String desc_problema, Date data, Boolean status, UUID id_usuario) {
}
